package com.iba.service;

import java.util.List;

import com.iba.entity.IPageInfo;
import com.iba.entity.User;

public interface UserService {

	List<User> findUserAllForMybatis();
	
	List<User> findUserAllForMybatisXml();
	
	IPageInfo findUserAllByPage(int pageNum, int pageSize);
	
	List<User> addManySource(User user);
}
