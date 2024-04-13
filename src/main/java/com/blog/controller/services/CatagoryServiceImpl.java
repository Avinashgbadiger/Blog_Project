package com.blog.controller.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Exception.ResourceNotFoundException;
import com.blog.model.Catagory;
import com.blog.repository.CatagoryRepo;
import com.blog.utils.CatagoryDto;

import jakarta.transaction.Transactional;

@Service
public class CatagoryServiceImpl implements CatagoryService {

	@Autowired
	private CatagoryRepo caRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CatagoryDto> getAll() {
		List<Catagory> findAll = this.caRepo.findAll();
		return findAll.stream().map(e -> this.converToDto(e)).toList();
	}

	@Override
	public CatagoryDto getById(int id) {
		Catagory orElseThrow = this.caRepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Catagory", "ID", id));
		return this.converToDto(orElseThrow);
	}

	@Transactional
	@Override
	public CatagoryDto saving(CatagoryDto dto) {
		Catagory convertToCatagory = this.convertToCatagory(dto);
		Catagory save = this.caRepo.save(convertToCatagory);
		return this.converToDto(save);
	}

	@Transactional
	@Override
	public CatagoryDto updateCatagory(CatagoryDto dto,int id) {
		Catagory orElseThrow = this.caRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "ID", id));

		orElseThrow.setCatagoryDescription(dto.getCatagoryDescription());
		orElseThrow.setCatagoryTitle(dto.getCatagoryTitle());
		CatagoryDto converToDto = this.converToDto(orElseThrow);
		 return converToDto;
	}
 
	@Transactional
	@Override
	public void deleteCatagory(int id) {
		Catagory orElseThrow = this.caRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Catagory", "ID", id));
		
		
		this.caRepo.delete(orElseThrow);

	}

	public CatagoryDto converToDto(Catagory catagory) {
		return this.mapper.map(catagory, CatagoryDto.class);
	}

	public Catagory convertToCatagory(CatagoryDto dto) {
		return this.mapper.map(dto, Catagory.class);
	}

}
