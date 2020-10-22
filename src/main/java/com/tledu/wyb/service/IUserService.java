package com.tledu.wyb.service;

import java.util.List;

import com.tledu.wyb.model.User;
import com.tledu.wyb.util.ERPException;

public interface IUserService {
	/**
	 * 登陆方法
	 * 
	 * @param user
	 * @return
	 * @throws ERPException
	 */
	public User login(User user) throws ERPException;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> list();

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
	 * 
	 * 校验用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	public boolean verifyUsername(String username);

	/**
	 * 根据ID 查询用户
	 * 
	 * @param id
	 * @return
	 */
	public User load(int id);
	
	public void update(User user);
}
