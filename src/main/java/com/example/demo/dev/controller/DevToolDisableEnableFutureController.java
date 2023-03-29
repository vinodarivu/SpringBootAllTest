package com.example.demo.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevToolDisableEnableFutureController {
	Logger log = LoggerFactory.getLogger(DevToolDisableEnableFutureController.class);

	@PostMapping("/newFeature")
	public String newFeature() {
		log.info("new Feature added");
		return "new Feature";
	}

}
