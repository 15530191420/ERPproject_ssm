package com.tledu.wyb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.IDeptDao;
import com.tledu.wyb.model.Dept;

@Repository
public class DeptDao extends SqlSessionDaoSupport implements IDeptDao {
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<Dept> list() {
		return getSqlSession().getMapper(IDeptDao.class).list();
	}

	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IDeptDao.class).delete(id);
		
	}

	@Override
	public void add(Dept dept) {
		getSqlSession().getMapper(IDeptDao.class).add(dept);
		
	}

	@Override
	public Dept loadByName(String name) {
		return getSqlSession().getMapper(IDeptDao.class).loadByName(name);
	}

	@Override
	public Dept load(int id) {
		return getSqlSession().getMapper(IDeptDao.class).load(id);
	}

	@Override
	public void update(Dept dept) {
		getSqlSession().getMapper(IDeptDao.class).update(dept);
	}

	
}
