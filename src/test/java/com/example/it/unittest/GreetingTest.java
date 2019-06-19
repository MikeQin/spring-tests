package com.example.it.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.it.Greeting;

public class GreetingTest {
	
	private Greeting mockGreeting;
	private String message;
	
	
	@Before
	public void setUp() {
		mockGreeting = new Greeting("Hello World");
		message = "Hello World";
	}
	
	@Test
	public void testGreetingMessage() {
		assertEquals(message, mockGreeting.getMessage());
	}

}
