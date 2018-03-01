package com.iba.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis
 * @Title RedisController
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月25日
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping("/get/{key}")
	public String get(@PathVariable String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	@RequestMapping("/set/{key}/{value}")
	public void set(@PathVariable String key, @PathVariable String value) {
		redisTemplate.opsForValue().set(key, value, 100, TimeUnit.SECONDS);
	}
}
