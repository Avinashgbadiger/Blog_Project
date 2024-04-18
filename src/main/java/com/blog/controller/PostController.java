package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.PostService;
import com.blog.utils.ApiResponse;
import com.blog.utils.PostDto;
import com.blog.utils.PostResponse;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	private PostService service;
	
	
	//Saving Post
	@PostMapping("/user/{userId}/catagory/{catagoryId}")
	public ResponseEntity<PostDto> savingPost(@RequestBody PostDto dto,@PathVariable Integer userId,@PathVariable Integer catagoryId)
	{
		PostDto saving = this.service.saving(dto, userId, catagoryId);
		return new ResponseEntity<PostDto>(saving,HttpStatus.ACCEPTED);
	}
	
	
	//Getting post by user
	@GetMapping("/user/{id}/post")
	public ResponseEntity<List<PostDto>> getAllPostByUser(@PathVariable int id)
	{
		List<PostDto> byUser = this.service.byUser(id);
		return new ResponseEntity<List<PostDto>>(byUser,HttpStatus.OK);
	}
	
	//Getting Post by Catagory
	@GetMapping("/catagory/{id}/post")
	public ResponseEntity<List<PostDto>> getAllPostByCatagory(@PathVariable int id)
	{
		List<PostDto> byUser = this.service.byCatagory(id);
		return new ResponseEntity<List<PostDto>>(byUser,HttpStatus.OK);
	}
	
	//Get All Post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize
			
			)
	{
		 PostResponse gettingAll = this.service.gettingAll(pageNumber, pageSize);
		
		return new ResponseEntity<PostResponse>(gettingAll,HttpStatus.ACCEPTED);
	}
	
	
	//Get Post by id
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getById(@PathVariable int id)
	{
		 
		
		return new ResponseEntity<PostDto>(this.service.getPostById(id),HttpStatus.ACCEPTED);
	}
	
	
	//Updating the Post 
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updaingPost(@RequestBody PostDto dto,@PathVariable int id)
	{
		return new ResponseEntity<PostDto>(this.service.updatingPost(dto, id),HttpStatus.ACCEPTED);
	}
	
	//Deleting Post By Id
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse>  deletingById(@PathVariable int id)
	{
		this.service.deletePost(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully ", true),HttpStatus.OK);
	}
	
	
	

}
