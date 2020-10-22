package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Performance;

public interface IPerformanceDao {
	/**
	 * 查询所有调职信息
	 * @return
	 */
	public List<Performance> list() ;
	public List<Performance> list(String progTheme);
	/**
	 * 添加调职申请单
	 * 
	 * @param user
	 */
	public void add(Performance performance);
	/**
	 * 根据申请人名字查询申请列表
	 * 
	 * @param username
	 * @return
	 */
	public Performance loadByprogTheme(String progTheme);
	
	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 根据ID 查询调职单
	 * 
	 * @param id
	 * @return
	 */
	public Performance load(int id);
	
	public void update(Performance performance);
}
