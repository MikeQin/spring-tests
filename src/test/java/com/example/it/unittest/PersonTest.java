package com.example.it.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.it.Greeting;
import com.example.it.Person;

public class PersonTest {
	
	Person mockPerson;
	Greeting greeting;
	
	@Before
	public void setUp() {
		mockPerson = new Person();
	}
	
	@Test
	public void testSay() {
		String myMsg = "Hello";
		greeting = mockPerson.say("Hello");
		
		assertEquals(myMsg, greeting.getMessage());
	}
	
	@Test
	public void testWalk() {
		int milesToWalk = 10;
		int milesWalked = mockPerson.walk(10);
		
		assertEquals(milesToWalk, milesWalked);
	}

}
