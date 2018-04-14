package com.iba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.iba.entity.User;


@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

	@Select("select * from user")
	public List<User> findUserAll();
}
