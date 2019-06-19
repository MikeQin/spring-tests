package com.example.it;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController {
	
	@GetMapping(path = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Greeting> greet() {
		Greeting greeting = new Greeting("Hello Spring");
		log.info("[*] {}", greeting);
		
		return ResponseEntity.ok(greeting);
	}

}
