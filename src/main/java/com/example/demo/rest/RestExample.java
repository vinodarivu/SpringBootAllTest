package com.example.demo.rest;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.rest.model.ContentNegotiationRequest;
import com.example.demo.rest.model.ContentNegotiationResponse;

@RestController
public class RestExample {
	
	 int hitcount = 0;
	
	@GetMapping("/getData")
	public ResponseEntity<Object> getData(@RequestParam  String userName){
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userName).toUri(); 
		return ResponseEntity.created(location).build();  
	}
	
	/*Content negotiation*/
	@PostMapping(path="/contentNego",  produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.ALL_VALUE)
	public ContentNegotiationResponse contentNego(@RequestBody ContentNegotiationRequest data) {
		
		ContentNegotiationResponse cr = new ContentNegotiationResponse();
		cr.setResponse("Success");
		
		return cr;
		
	}
	
	/*Content negotiation*/
	@PutMapping(path="/contentNego",  produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.ALL_VALUE)
	public ContentNegotiationResponse contentNegoPut(@RequestBody ContentNegotiationRequest data) {
		++hitcount;
		ContentNegotiationResponse cr = new ContentNegotiationResponse();
		cr.setResponse("Success");
		
		return cr;
		
	}

}
