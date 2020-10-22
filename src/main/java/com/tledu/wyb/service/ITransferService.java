package com.tledu.wyb.service;

import java.util.List;

import com.tledu.wyb.model.Dept;
import com.tledu.wyb.model.Transfer;

public interface ITransferService {
	/**
	 * 查询所有调职申请
	 * 
	 * @return
	 */
	public List<Transfer> list();
	
	/**
	 * 新建调职申请
	 * @param transfer
	 */
	public void add(Transfer transfer);
	
	/**
	 * 
	 * 校验申请人名是否存在
	 * 
	 * @param username
	 * @return
	 */
	public boolean verifyApplyname(String applyname);
	
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
	public Transfer load(int id);
	
	public void update(Transfer transfer);
}
