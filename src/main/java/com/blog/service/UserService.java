package com.blog.service;

import java.util.List;

import com.blog.utils.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, int userId);

	void deleteUser(int id);

	List<UserDto> getAllUser();

	UserDto getUserById(int id);
	
	


}
