package com.blog.service;

import java.util.List;

import com.blog.utils.PostDto;
import com.blog.utils.PostResponse;

public interface PostService {

	// creating Post
	 PostDto saving(PostDto dto, Integer userId, Integer catagoryId);

	// Getting Post by id
	public PostDto getPostById(int id);

	// Get All Post
	public PostResponse gettingAll(Integer pageNumber,Integer pageSize);

	// Update a Post
	public PostDto updatingPost(PostDto dto, int id);

	// Deleting a Post
	public void deletePost(int id);

	// Get all Post through User
	public List<PostDto> byUser(int userId);

	// Get all Post through category
	public List<PostDto> byCatagory(int catId);

	// Search by Keyword
	public List<PostDto> searchByKeyword(String keyword);

}
