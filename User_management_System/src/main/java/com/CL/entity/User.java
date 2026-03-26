package com.CL.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
	@Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
	private String userName;

	@Column(unique = true)
	@Email(message = "Invalid email format")
	@NotEmpty(message = "Email is required")
	@Size(max = 100, message = "Email must not exceed 100 characters")
	private String email;

	public User(String userName, String email) {
	
		this.userName = userName;
		this.email = email;
	}

}
