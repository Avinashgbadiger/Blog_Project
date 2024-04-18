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
import org.springframework.web.bind.annotation.RestController;

import com.blog.controller.services.CatagoryService;
import com.blog.utils.ApiResponse;
import com.blog.utils.CatagoryDto;

@RestController
@RequestMapping("/api/catagory")
public class CatagoryController {

	@Autowired
	private CatagoryService service;

	@PostMapping("/")
	public ResponseEntity<CatagoryDto> savingCatagory(@RequestBody CatagoryDto dto) {
		CatagoryDto saving = this.service.saving(dto);
		return new ResponseEntity<CatagoryDto>(saving, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CatagoryDto> getById(@PathVariable int id) {
		CatagoryDto byId = this.service.getById(id);
		return new ResponseEntity<CatagoryDto>(byId, HttpStatus.ACCEPTED);
	}

	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto>> getAll() {
		List<CatagoryDto> all = this.service.getAll();
		return ResponseEntity.ok(all);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CatagoryDto> updating(@RequestBody CatagoryDto dto, @PathVariable int id) {
		CatagoryDto updateCatagory = this.service.updateCatagory(dto, id);
		return new ResponseEntity<CatagoryDto>(updateCatagory, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletingCat(@PathVariable int id) {
		this.service.deleteCatagory(id);
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Catagory with Id " + id + " Deleted Successfully", true), HttpStatus.ACCEPTED);
	}

}
