package com.tledu.wyb.service;

import java.util.List;

import com.tledu.wyb.model.Quality;

public interface IQualityService {
	/**
	 * 查询所有调职申请
	 * 
	 * @return
	 */
	public List<Quality> list();
	
	/**
	 * 新建调职申请
	 * @param transfer
	 */
	public void add(Quality quality);
	
	/**
	 * 
	 * 校验申请人名是否存在
	 * 
	 * @param username
	 * @return
	 */
	public boolean verifyQualityTheme(String qualityTheme);
	
	/**
	 * 根据ID删除申请单
	 * 
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 根据ID 查询申请单
	 * 
	 * @param id
	 * @return
	 */
	public Quality load(int id);
	
	public void update(Quality quality);
}
