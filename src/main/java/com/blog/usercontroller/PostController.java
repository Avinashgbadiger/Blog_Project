package com.blog.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.controller.services.PostService;
import com.blog.utils.PostDto;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping("/user/{userId}/catagory/{catagoryId}")
	public ResponseEntity<PostDto> savingPost(@RequestBody PostDto dto,@PathVariable Integer userId,@PathVariable Integer catagoryId)
	{
		PostDto saving = this.service.saving(dto, userId, catagoryId);
		return new ResponseEntity<PostDto>(saving,HttpStatus.ACCEPTED);
	}

}
