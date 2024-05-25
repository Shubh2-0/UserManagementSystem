package com.CL.controller;

import org.springframework.web.bind.annotation.*;

import com.CL.entity.User;
import com.CL.exception.InvalidUserDataException;
import com.CL.exception.UserNotFoundException;
import com.CL.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired

	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		try {
			User user = userService.getUserById(id);
			return ResponseEntity.ok(user);
		} catch (UserNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		try {
			User createdUser = userService.createUser(user);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (InvalidUserDataException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	
}
