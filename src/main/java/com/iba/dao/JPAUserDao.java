package com.iba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.iba.entity.User;

/**
 * 	如果你的查询列表是没有查询条件，只是列表展示和分页，只需继承JpaRepository接口即可，
 * 	但是如果你的查询列表是带有多个查询条件的话则需要继承JpaSpecificationExecutor接口，
 * 	这个接口里面定义的多条件查询的方法。当然不管继承哪个接口，当你做分页查询时，都是需要调用findAll方法的，这个方法是jpa定义好的分页查询方法
 * @Title JPAUserDao
 * @Description :
 * @Author: ~琴兽~
 * @Date:2018年2月25日
 */
@Repository
public interface JPAUserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
