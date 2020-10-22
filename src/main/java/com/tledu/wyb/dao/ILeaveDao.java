package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Leave;
import com.tledu.wyb.model.Payment;

public interface ILeaveDao {
	/**
	 * 查询所有调职信息
	 * 
	 * @return
	 */
	public List<Leave> list();
	public List<Leave> list(String leavename) ;
	/**
	 * 根据ID删除用户
	 * 
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 添加调职申请单
	 * 
	 * @param user
	 */
	public void add(Leave leave);
	/**
	 * 根据申请人名字查询申请列表
	 * 
	 * @param username
	 * @return
	 */
	public Leave loadByLeavename(String leavename);
	
	/**
	 * 根据ID 查询离职单
	 * 
	 * @param id
	 * @return
	 */
	public Leave load(int id);
	
	public void update(Leave leave);
}
