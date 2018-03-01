package com.iba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Freemarker模板
 * @Title FreemarkerController
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月24日
 */
@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

	@RequestMapping
	public String index(Model model) {
		model.addAttribute("title", "hello world freemarker");
		return "freemarker";
	}
}
