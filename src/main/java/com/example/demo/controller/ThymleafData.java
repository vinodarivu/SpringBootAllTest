package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymleafData {
	
	@RequestMapping("/getHtml")
	public String getData() {
		return "data";
	}

}
