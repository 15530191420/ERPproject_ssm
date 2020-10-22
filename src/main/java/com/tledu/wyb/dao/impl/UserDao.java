package com.tledu.wyb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.IUserDao;
import com.tledu.wyb.model.User;

@Repository
public class UserDao extends SqlSessionDaoSupport implements IUserDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public User loadByUsername(String username) {
		return getSqlSession().getMapper(IUserDao.class).loadByUsername(username);
	}

	@Override
	public List<User> list() {
		return getSqlSession().getMapper(IUserDao.class).list();
	}

	@Override
	public List<User> list1(String username) {
		return getSqlSession().getMapper(IUserDao.class).list1(username);
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IUserDao.class).delete(id);
	}

	@Override
	public void add(User user) {
		getSqlSession().getMapper(IUserDao.class).add(user);
	}

	@Override
	public User load(int id) {
		return getSqlSession().getMapper(IUserDao.class).load(id);
	}

	@Override
	public void update(User user) {
		getSqlSession().getMapper(IUserDao.class).update(user);
	}

	@Override
	public int loadByDeptId(int deptId) {
		return getSqlSession().getMapper(IUserDao.class).loadByDeptId(deptId);
	}

	
}
