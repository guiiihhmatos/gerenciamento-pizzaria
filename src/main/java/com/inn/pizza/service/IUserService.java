package com.inn.pizza.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface IUserService {
	
	ResponseEntity<String> signUp(Map<String, String> requestMap);
}
