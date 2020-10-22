package com.tledu.wyb.service;

import java.util.List;

import com.tledu.wyb.model.Leave;

public interface ILeaveService {
	/**
	 * 查询所有离职申请单
	 * 
	 * @return
	 */
	public List<Leave> list();
	
	/**
	 * 新建调职申请
	 * @param transfer
	 */
	public void add(Leave leave);
	
	/**
	 * 
	 * 校验申请人名是否存在
	 * 
	 * @param leavename
	 * @return
	 */
	public boolean verifyLeavename(String leavename);
	
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
	public Leave load(int id);
	
	public void update(Leave leave);
}
