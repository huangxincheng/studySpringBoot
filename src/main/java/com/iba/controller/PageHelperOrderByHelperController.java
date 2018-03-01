package com.iba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iba.entity.IPageInfo;
import com.iba.service.UserService;

@RequestMapping("pagehelper_orderbyhelper")
@RestController
public class PageHelperOrderByHelperController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{pageNum}/{pageSize}")
	public IPageInfo index(@PathVariable int pageNum, @PathVariable int pageSize) {
		return userService.findUserAllByPage(pageNum, pageSize);
	}
}
