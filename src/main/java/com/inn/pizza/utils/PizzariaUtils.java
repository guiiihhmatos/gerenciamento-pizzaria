 package com.inn.pizza.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PizzariaUtils {
	
	private PizzariaUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
		
		return new ResponseEntity<String>("{\"message\":\""+ responseMessage +"\"}", httpStatus);
	}
}
