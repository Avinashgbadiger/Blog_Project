package com.blog.utils;

import java.util.Date;

import com.blog.model.Catagory;
import com.blog.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private String postTitle;

	private String imageName;

	private String content;

	private Date addDate;

	private CatagoryDto catagory;

	private UserDto user;
}
