package com.iba.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iba.dao.JPAUserDao;
import com.iba.dao.MybatisUserMapper;
import com.iba.entity.IPageInfo;
import com.iba.entity.User;
import com.iba.service.UserService;
import com.iba.utils.datasource.annotation.IDynamicAnnotation;

import tk.mybatis.orderbyhelper.OrderByHelper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private JPAUserDao jpaUserDao;
	
	@Autowired
	private MybatisUserMapper mybatisUserDao;
	
	@Override
	@IDynamicAnnotation("localhost")
	public List<User> findUserAllForJPA() {
		return jpaUserDao.findAll();
	}

	@Override
	public User addForJPA(User user) {
		return jpaUserDao.save(user);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<User> addTransactionalForJPA(User user1, User user2) {
		List<User> users = new ArrayList<>();
		users.add(jpaUserDao.save(user1));
		users.add(jpaUserDao.save(user2));
		return users;
	}

	@Override
	public List<User> findUserAllForMybatis() {
		return mybatisUserDao.findAll();
	}

	@Override
	public List<User> findUserAllForMybatisXml() {
		return mybatisUserDao.findAllForXml();
	}

	@Override
	public IPageInfo findUserAllByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		OrderByHelper.orderBy("id desc");
		List<User> list = findUserAllForMybatis();
		return IPageInfo.instance(list);
	}

}
