package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Catagory;

@Repository
public interface CatagoryRepo extends JpaRepository<Catagory,Integer> {

}
