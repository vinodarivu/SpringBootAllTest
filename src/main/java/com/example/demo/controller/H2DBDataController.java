package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookEntity;
import com.example.demo.repo.BookEntityRepo;

@RestController
public class H2DBDataController {

	@Autowired
	BookEntityRepo bookEntityRepo;

	@GetMapping("/getBookById")
	public BookEntity getBookData(@RequestParam Long id) {
		BookEntity be = bookEntityRepo.findById(id).get(); 
		return be;
	}
	@GetMapping("/getBookByAge")
	public List<BookEntity> getBookByAge(@RequestParam int age) {
		List<BookEntity> be = bookEntityRepo.findByAge(age); 
		return be;
	}

	@PostMapping("/addNewBook")
	public void getBookData(@RequestBody BookEntity be) {
		bookEntityRepo.save(be);
		
	}
	
	@DeleteMapping("/deleteBookById")
	public void deleteBookById(@RequestParam Long id) {
		bookEntityRepo.deleteById(id);
		
	}
	

}
