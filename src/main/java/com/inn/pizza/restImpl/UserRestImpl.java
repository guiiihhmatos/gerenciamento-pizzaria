package com.inn.pizza.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.pizza.constents.PizzariaConstant;
import com.inn.pizza.rest.IUserRest;
import com.inn.pizza.service.IUserService;
import com.inn.pizza.utils.PizzariaUtils;

@RestController
public class UserRestImpl implements IUserRest{
	
	@Autowired
	IUserService iUserService;
	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		try {
			
			return iUserService.signUp(requestMap);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return PizzariaUtils.getResponseEntity(PizzariaConstant.errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
