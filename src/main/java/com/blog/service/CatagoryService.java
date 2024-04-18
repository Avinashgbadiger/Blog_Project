package com.blog.service;

import java.util.List;

import com.blog.utils.CatagoryDto;

public interface CatagoryService {

	
	 List<CatagoryDto> getAll();
	 
	 CatagoryDto getById(int id);
	 
	 CatagoryDto saving(CatagoryDto dto);
	 
	 CatagoryDto updateCatagory(CatagoryDto dto,int id);
	 
	 void deleteCatagory(int id);
	 
}
