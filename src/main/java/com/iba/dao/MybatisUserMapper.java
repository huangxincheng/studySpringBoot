package com.iba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.iba.entity.User;

@Mapper
public interface MybatisUserMapper {
	
	
	@Select(value = "select * from user")
	public List<User> findAll();
	
	public List<User> findAllForXml();
	
	@Insert("insert into user(username,name,age,balance) values(#{username},#{name},#{age},#{balance})")
	public void insert(User user);
}
