package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.ILeaveDao;
import com.tledu.wyb.model.Leave;
import com.tledu.wyb.service.ILeaveService;
@Service
public class LeaveService implements ILeaveService{
	@Autowired
	private ILeaveDao leaveDao;
	@Override
	public List<Leave> list() {
		return leaveDao.list();
	}
	@Override
	public void add(Leave leave) {
		leaveDao.add(leave);
	}
	@Override
	public boolean verifyLeavename(String leavename) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void delete(int id) {
		leaveDao.delete(id);
		
	}
	@Override
	public Leave load(int id) {
		return leaveDao.load(id);
	}
	@Override
	public void update(Leave leave) {
		leaveDao.update(leave);
		
	}

}
