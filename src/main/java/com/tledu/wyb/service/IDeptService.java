package com.tledu.wyb.service;

import java.util.List;

import com.tledu.wyb.model.Dept;
import com.tledu.wyb.util.ERPException;

public interface IDeptService {
	public  List<Dept> list();
	
	/**
	 * 根据ID删除部门,如果该部门下有员工,则不能删除该部门
	 * 
	 * @param id
	 */
	public void delete(int id) throws ERPException;

	/**
	 * 添加部门
	 * 
	 * @param user
	 */
	public void add(Dept dept);

	/**
	 * 
	 * 校验部门名称是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean verifyName(String name);

	/**
	 * 根据ID 查询部门
	 * 
	 * @param id
	 * @return
	 */
	public Dept load(int id);
	
	public void update(Dept dept);
}
