package com.iba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.dao.UserMapper;
import com.iba.entity.User;

@RestController
@RequestMapping("/mapper")
public class MapperController {

	@Autowired
	private UserMapper mapper;
	
	@RequestMapping
	public User index() {
		return mapper.selectByPrimaryKey(1L);
	}
	
	@RequestMapping("/findUserAll")
	public List<User> findUserAll() {
		return mapper.findUserAll();
	}
}
