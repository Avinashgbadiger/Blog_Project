package com.blog.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	@Column(name = "post_Tile", length = 16, nullable = false)
	private String postTitle;

	private String imageName;
	@Column(length = 100)
	private String content;
	private Date addDate;

	@ManyToOne
	private Catagory catagory;

	@ManyToOne
	private User user;

}
