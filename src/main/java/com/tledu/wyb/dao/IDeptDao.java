package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Dept;

public interface IDeptDao {
	public  List<Dept> list();
	/**
	 * 根据ID删除部门
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 添加部门
	 * 
	 * @param user
	 */
	public void add(Dept dept);

	/**
	 * 根据部门名称查询部门
	 * 
	 * @param username
	 * @return
	 */
	public Dept loadByName(String name);
	/**
	 * 根据ID 查询部门
	 * 
	 * @param id
	 * @return
	 */
	public Dept load(int id);
	
	public void update(Dept dept);
}
