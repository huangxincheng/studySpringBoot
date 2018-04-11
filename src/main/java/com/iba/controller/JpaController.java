//package com.iba.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.iba.entity.User;
//import com.iba.service.UserService;
//
///**
// * JPA
// * @Title JpaController
// * @Description :
// * @Author: ~琴兽~
// * @Date:2018年2月25日
// */
//@RestController
//@RequestMapping("/jpa")
//public class JpaController {
//
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping("/index")
//	public String index() {
//		return "hello world";
//	}
//	
//	@RequestMapping("/all")
//	public List<User> findUserAll() {
//		return userService.findUserAllForJPA();
//	}
//	
//}
