package com.iba.service;

import java.util.List;

import com.iba.entity.IPageInfo;
import com.iba.entity.User;

public interface UserService {

	List<User> findUserAllForJPA();
	
	User addForJPA(User user);
	
	List<User> addTransactionalForJPA(User user1, User user2);
	
	List<User> findUserAllForMybatis();
	
	List<User> findUserAllForMybatisXml();
	
	IPageInfo findUserAllByPage(int pageNum, int pageSize);
}
