package com.blog.usercontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.controller.services.UserServiceImpl;
import com.blog.utils.ApiResponse;
import com.blog.utils.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserServiceImpl serviceImpl;

	// Post
	@PostMapping("/")
	public ResponseEntity<UserDto> saving(@Valid @RequestBody UserDto userDto) {
		UserDto createUser = this.serviceImpl.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	// Get

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll() {

		return ResponseEntity.ok(this.serviceImpl.getAllUser());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
		return new ResponseEntity<>(this.serviceImpl.getUserById(id),HttpStatus.ACCEPTED);
	}

	// Put

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updating(@Valid @RequestBody UserDto userDto, @PathVariable Integer id ) {
		 
		UserDto updateUser = this.serviceImpl.updateUser(userDto, id);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
	}
	// Delete

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleting(@PathVariable Integer id) {

		this.serviceImpl.deleteUser(id);
		 
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted :", true), HttpStatus.OK);

	}

}
