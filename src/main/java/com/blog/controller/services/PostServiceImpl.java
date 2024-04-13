package com.blog.controller.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.blog.utils.PostResponse;
import com.blog.utils.UserDto;

import jakarta.transaction.Transactional;

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

	@Transactional
	@Override
	public PostDto saving(PostDto dto, Integer userId, Integer catagoryId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		Catagory catagory = this.catRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "Id", catagoryId));

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
		 Post orElseThrow = this.postRepo.findById(id)
				 .orElseThrow(()-> new ResourceNotFoundException("Post", "Id", id));
		 
		return this.mapper.map(orElseThrow, PostDto.class);
	}

	@Override
	public PostResponse gettingAll(Integer pageNumber,Integer pageSize) {
		// TODO Auto-generated method stub
		
		Pageable of = PageRequest.of(pageNumber, pageSize);
		Page<Post> findAll = this.postRepo.findAll(of);
		 
		 List<Post> content = findAll.getContent();
		 List<PostDto> list = content.stream().map((p)->this.mapper.map(p, PostDto.class)).toList();
				 PostResponse postResponse=new PostResponse();
				 postResponse.
				 setContent(findAll.getContent().stream()
						 .map((p)-> this.mapper
								 .map(p, PostDto.class)).toList());
				 postResponse.setPageNumber(findAll.getNumber());
				 postResponse.setPageSize(findAll.getSize());
				 postResponse.setTotalElement(findAll.getTotalElements());
				 postResponse.setTotalPages(findAll.getTotalPages());
				 postResponse.setLastPage(findAll.isLast());
						  
				 
		 
		return postResponse;
	}

	@Transactional
	@Override
	public PostDto updatingPost(PostDto dto, int id) {
		// TODO Auto-generated method stub
		Post orElseThrow = this.postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Id", id));
		Post map = this.mapper.map(dto, Post.class);
		
		Post save = this.postRepo.save(map);
		
		return this.mapper.map(save, PostDto.class);
	}

	@Transactional
	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		
		this.postRepo.deleteById(id);

	}

	@Override
	public List<PostDto> byUser(int userId) {
		User orElseThrow = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "Id", userId));
		List<PostDto> byCatagory = this.postRepo.getByUser(orElseThrow).stream()
				.map((post) -> this.mapper.map(post, PostDto.class)).toList();

		return byCatagory;

	}

	@Override
	public List<PostDto> byCatagory(int catId) {
		// TODO Auto-generated method stub
		Catagory orElseThrow = this.catRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "Id", catId));
		List<PostDto> byCatagory = this.postRepo.getByCatagory(orElseThrow).stream()
				.map((post) -> this.mapper.map(post, PostDto.class)).toList();

		return byCatagory;
	}

	@Override
	public List<PostDto> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post dtoToPost(PostDto dto) {
		return this.mapper.map(dto, Post.class);
	}

	public PostDto postToDto(Post post) {
		return this.mapper.map(post, PostDto.class);
	}

}
