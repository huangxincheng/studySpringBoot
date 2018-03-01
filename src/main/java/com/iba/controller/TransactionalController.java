package com.iba.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.User;
import com.iba.service.UserService;

/**
 * 测试事务
 * @Title TransactionalController
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月24日
 */
@RestController
@RequestMapping("/transactional")
public class TransactionalController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/add/{username}/{name}/{age}/{balance}")
	public User add(@PathVariable(required = true) String username,
					@PathVariable(required = true)String name, 
					@PathVariable(required = true)Integer age, 
					@PathVariable(required = true)BigDecimal balance) {
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setAge(age);
		user.setBalance(balance);
		return userService.addForJPA(user);
	}
	
	@RequestMapping("/addForTransactional/{username1}/{name1}/{age1}/{balance1}/{username2}/{name2}/{age2}/{balance2}")
	public List<User> addForTransactional(
			@PathVariable(required = true) String username1,
			@PathVariable(required = true)String name1, 
			@PathVariable(required = true)Integer age1, 
			@PathVariable(required = true)BigDecimal balance1,
			@PathVariable(required = true) String username2,
			@PathVariable(required = true)String name2, 
			@PathVariable(required = true)Integer age2, 
			@PathVariable(required = true)BigDecimal balance2) {
		User user1 = new User();
		user1.setUsername(username1);
		user1.setName(name1);
		user1.setAge(age1);
		user1.setBalance(balance1);
		User user2 = new User();
		user2.setUsername(username2);
		user2.setName(name2);
		user2.setAge(age2);
		user2.setBalance(balance2);
		return userService.addTransactionalForJPA(user1, user2);
	}
}
