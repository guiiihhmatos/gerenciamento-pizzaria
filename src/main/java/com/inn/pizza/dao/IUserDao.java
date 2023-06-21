package com.inn.pizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inn.pizza.pojo.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	
	User findByEmailId(@Param("email") String email);
}
