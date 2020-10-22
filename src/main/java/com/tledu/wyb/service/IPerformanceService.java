package com.tledu.wyb.service;

import java.util.List;

import com.tledu.wyb.model.Payment;
import com.tledu.wyb.model.Performance;

public interface IPerformanceService {
	/**
	 * 查询所有调职申请
	 * 
	 * @return
	 */
	public List<Performance> list();
	
	/**
	 * 新建调职申请
	 * @param transfer
	 */
	public void add(Performance performance);
	
	/**
	 * 
	 * 校验申请人名是否存在
	 * 
	 * @param username
	 * @return
	 */
	public boolean verifyProgTheme(String progTheme);
	
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
	public Performance load(int id);
	
	public void update(Performance performance);
}
