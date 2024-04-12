package com.blog.controller.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Exception.ResourceNotFoundException;
import com.blog.model.User;
import com.blog.repository.UserRepo;
import com.blog.utils.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User dtoToUser = this.dtoToUser(userDto);
		User save = this.userRepo.save(dtoToUser);
		return this.userToDto(save);

	}

	@Override
	public UserDto updateUser(UserDto userDto, int userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setId(userId);
		user.setAbout(userDto.getAbout());
		this.userRepo.save(user);

		UserDto userToDto = this.userToDto(user);

		return userToDto;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		this.userRepo.delete(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> findAll = this.userRepo.findAll();
		List<UserDto> list = findAll.stream().map(user -> this.userToDto(user)).toList();
		return list;
	}

	@Override
	public UserDto getUserById(int id) {
		User orElseThrow = this.userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		UserDto userToDto = this.userToDto(orElseThrow);
		return userToDto;
	}

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto,User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;

	}

	public UserDto userToDto(User user) {
		UserDto dto =this.modelMapper.map(user, UserDto.class);
//		dto.setAbout(user.getAbout());
//		dto.setEmail(user.getEmail());
//		dto.setId(user.getId());
//		dto.setPassword(user.getPassword());
//		dto.setName(user.getName());
		return dto;
	}

}
