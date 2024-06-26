package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Catagory;
import com.blog.model.Post;
import com.blog.model.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> getByUser(User user);

	List<Post> getByCatagory(Catagory catagory);
}
