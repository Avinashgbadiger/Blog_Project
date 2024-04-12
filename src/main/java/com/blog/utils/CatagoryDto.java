package com.blog.utils;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryDto {
	
	private int catagoryId;
	@Length(min = 3,max = 16,message = "Title should min 3 and max 16...!")
	private String catagoryTitle;
	
	@Length(max = 500,message = "Description limit is 500 charaters ...!")
	private String catagoryDescription;

}
