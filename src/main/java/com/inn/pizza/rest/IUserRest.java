package com.inn.pizza.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/user")
public interface IUserRest {
	
	@PostMapping(path = "/signup")
	public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);
}