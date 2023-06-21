package com.inn.pizza.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.pizza.constents.PizzariaConstant;
import com.inn.pizza.dao.IUserDao;
import com.inn.pizza.pojo.User;
import com.inn.pizza.service.IUserService;
import com.inn.pizza.utils.PizzariaUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserDao iUserDao;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		log.info("Inside signup{}", requestMap);
		
		try {
			
			if(validateSignUpMap(requestMap))
			{
				User user = iUserDao.findByEmailId(requestMap.get("email"));
				
				if(Objects.isNull(user))
				{
					iUserDao.save(getUserFromMap(requestMap));
					return PizzariaUtils.getResponseEntity(PizzariaConstant.registradoComSucesso, HttpStatus.OK);
				}
				else 
				{
					return PizzariaUtils.getResponseEntity(PizzariaConstant.emailExistente, HttpStatus.BAD_REQUEST);
				}
			}
			else
			{
				return PizzariaUtils.getResponseEntity(PizzariaConstant.loginInvalido, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			
			e.getStackTrace();
		}
		
		return PizzariaUtils.getResponseEntity(PizzariaConstant.errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		
		if(requestMap.containsKey("nome") && requestMap.containsKey("contato")
				&& requestMap.containsKey("email") && requestMap.containsKey("senha")) 
		{
			return true;
		}
		
		return false;
		
	}
	
	private User getUserFromMap(Map<String, String> requestMap)
	{
		User user = new User();
		
		user.setNome(requestMap.get("nome"));
		user.setContato(requestMap.get("contato"));
		user.setEmail(requestMap.get("email"));
		user.setSenha(requestMap.get("senha"));
		user.setStatus("false");
		user.setRole("user");
		
		return user;
	}

}
