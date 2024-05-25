package com.CL.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
 

	@NotEmpty(message = "Username is required")
	private String userName;
	

	@Email(message = "Invalid email format")
	@NotEmpty(message = "Email is required")
	private String email;

	public User(String userName, String email) {
	
		this.userName = userName;
		this.email = email;
	}

}
