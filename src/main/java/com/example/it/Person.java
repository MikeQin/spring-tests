package com.example.it;

public class Person {

	public Greeting say(String message) {
		return new Greeting(message);
	}

	public int walk(int miles) {
		return miles;
	}

}
