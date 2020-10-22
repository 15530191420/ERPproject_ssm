package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Payment;
import com.tledu.wyb.model.Transfer;

public interface ITransferDao {
	/**
	 * 查询所有调职信息
	 * @return
	 */
	public List<Transfer> list() ;
	public List<Transfer> list(String applyname) ;
	/**
	 * 添加调职申请单
	 * 
	 * @param user
	 */
	public void add(Transfer transfer);
	/**
	 * 根据申请人名字查询申请列表
	 * 
	 * @param username
	 * @return
	 */
	public Transfer loadByApplyname(String applyname);
	
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
	public Transfer load(int id);
	
	public void update(Transfer transfer);

}
