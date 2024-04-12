package com.blog.controller.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Exception.ResourceNotFoundException;
import com.blog.model.Catagory;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.CatagoryRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.utils.CatagoryDto;
import com.blog.utils.PostDto;
import com.blog.utils.UserDto;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CatagoryRepo catRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PostDto saving(PostDto dto, Integer userId, Integer catagoryId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		Catagory catagory = this.catRepo.findById(catagoryId).orElseThrow(()->new ResourceNotFoundException("Catagory", "Id", catagoryId));
		 
		Post map = this.mapper.map(dto, Post.class);
		   map.setAddDate(new Date());
		   map.setImageName("default.png");
		   map.setUser(user);
		   map.setCatagory(catagory);
		   
		      
		   
		   PostDto map2 = this.mapper.map(map, PostDto.class);
		
		return map2;
	}

	@Override
	public PostDto getPostById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> gettingAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatingPost(PostDto dto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> byUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> byCatagory(int catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	
	 
}
