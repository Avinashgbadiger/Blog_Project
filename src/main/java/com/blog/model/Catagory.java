package com.blog.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catagories")
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catagoryId;
	@Column(name = "title", nullable = false)
	private String catagoryTitle;
	@Column(name = "description", length = 500)
	private String catagoryDescription;

	@OneToMany(mappedBy = "catagory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> post;

}
