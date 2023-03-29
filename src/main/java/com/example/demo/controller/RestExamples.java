package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controlAdvice.NoDataException;

@RestController
public class RestExamples {
	
	@RequestMapping("/getData")
	public String getData() {
		throw new NoDataException();
	}

}
