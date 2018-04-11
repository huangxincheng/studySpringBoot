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
	
	
	@RequestMapping("/addForManyDataSouce/{username}/{name}/{age}/{balance}")
	public List<User> addForManyDataSouce(
			@PathVariable  String username,
			@PathVariable String name, 
			@PathVariable Integer age, 
			@PathVariable BigDecimal balance) {
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setAge(age);
		user.setBalance(balance);
		return userService.addManySource(user);
	}
}
