package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Leave;
import com.tledu.wyb.model.User;

public interface IUserDao {
	/**
	 * 根据用户名,查询用户
	 * 
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> list();
	public List<User> list1(String username) ;

	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 添加用户,用户名不能重复
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * 根据ID 查询用户
	 * 
	 * @param id
	 * @return
	 */
	public User load(int id);
	public void update(User user);
	
	/**
	 * 根据部门ID查询,该部门下有多少人
	 * @param deptId
	 * @return
	 */
	public int loadByDeptId(int deptId);
	
	
}
