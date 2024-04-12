package com.blog.utils;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private int id;
	@NotEmpty
	@Length(min = 3,max = 16,message = "Name must be min 3 and Max 16 Characters..!!")
	private String name;
	@Email(message = "Email Address is not valid ...!!")
	private String email;
	@NotNull
	private String about;
	@NotEmpty
	@Length(min = 3 ,max = 16,message = "Password should be min 3 and max 16 characters...!!")
	private String password;
}
