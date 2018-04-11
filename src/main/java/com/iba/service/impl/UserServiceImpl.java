package com.iba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.iba.dao.MybatisUserMapper;
import com.iba.entity.IPageInfo;
import com.iba.entity.User;
import com.iba.service.UserService;
import com.iba.utils.datasource.IDynamicDataSource;

import tk.mybatis.orderbyhelper.OrderByHelper;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private MybatisUserMapper mybatisUserDao;
	
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

	public List<User> addManySource(User user) {
		IDynamicDataSource.putDataSourceKey("localhost");
		mybatisUserDao.insert(user);
		IDynamicDataSource.putDataSourceKey("u6");
		mybatisUserDao.insert(user);
		return null;
	}
	

}
