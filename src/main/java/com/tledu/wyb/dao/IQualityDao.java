package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Quality;

public interface IQualityDao {
	/**
	 * 查询所有调职信息
	 * @return
	 */
	public List<Quality> list() ;
	public List<Quality> list(String qualityTheme);
	/**
	 * 添加调职申请单
	 * 
	 * @param user
	 */
	public void add(Quality quality);
	/**
	 * 根据申请人名字查询申请列表
	 * 
	 * @param username
	 * @return
	 */
	public Quality loadByQualityTheme(String qualityTheme);
	
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
	public Quality load(int id);
	
	public void update(Quality quality);
}
