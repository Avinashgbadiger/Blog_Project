package com.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.repository.UserRepo;

@SpringBootTest
class Crud1ApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String name = this.userRepo.getClass().getName();
		System.out.println(name);
		Package package1 = this.userRepo.getClass().getPackage();
		System.out.println(package1);
	}

}
