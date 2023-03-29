package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BeanServices;

@RestController
public class BeanTestController {

	@Autowired
	BeanServices beanServices;

	@GetMapping("/startBeanTest")
	public void startBeanTest() {

		beanServices.testAllBeans();

	}

}
