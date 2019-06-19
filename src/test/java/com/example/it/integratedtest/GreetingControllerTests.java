package com.example.it.integratedtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.it.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerTests {

	@LocalServerPort
	private int port;

	private String endpoint;

	@Autowired
	TestRestTemplate restTemplate;
	
	@Before
	public void setUp() {

		System.out.println("---- Setup ----");
		endpoint = "http://localhost:" + port + "/api";
	}

	@Test
	public void testHttpStatusOK() {
		String status = "200 OK";
		ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.GET, null, String.class);
		assertThat(response.getStatusCode().toString()).isEqualTo(status);

		System.out.println("Status Code: " + response.getStatusCode().toString());		
	}
	
	@Test
	public void testGreetingMessage() {
		Greeting greeting = restTemplate.getForObject(endpoint, Greeting.class);
		assertThat(greeting.getMessage()).isEqualTo("Hello Spring");
	}
}
