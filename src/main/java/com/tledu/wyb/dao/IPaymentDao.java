package com.tledu.wyb.dao;

import java.util.List;

import com.tledu.wyb.model.Evaluation;
import com.tledu.wyb.model.Payment;
import com.tledu.wyb.model.User;

public interface IPaymentDao {
	/**
	 * 查询所有调职信息
	 * @return
	 */
	public List<Payment> list() ;
	public List<Payment> list(String theme);
	/**
	 * 添加调职申请单
	 * 
	 * @param user
	 */
	public void add(Payment payment);
	/**
	 * 根据申请人名字查询申请列表
	 * 
	 * @param username
	 * @return
	 */
	public Payment loadBytheme(String theme);
	
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
	public Payment load(int id);
	
	public void update(Payment payment);
}
