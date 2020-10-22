package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.IDeptDao;
import com.tledu.wyb.dao.IUserDao;
import com.tledu.wyb.model.Dept;
import com.tledu.wyb.service.IDeptService;
import com.tledu.wyb.util.ERPException;

@Service
public class DeptService implements IDeptService {
	
	@Autowired
	private IDeptDao deptDao;
	@Autowired
	private IUserDao userDao;

	@Override
	public List<Dept> list() {
		return deptDao.list();
	}

	@Override
	public void delete(int id) throws ERPException {
		// 根据部门ID 去t_user表中进行查询 count(*) 如果大于0 ,说明该部门下还有员工
		int count = userDao.loadByDeptId(id);
		if (count > 0) {
			throw new  ERPException("该部门下还有员工,不能删除哦~");
		}
		deptDao.delete(id);

	}

	@Override
	public void add(Dept dept) {
		deptDao.add(dept);

	}

	@Override
	public boolean verifyName(String name) {
		Dept dept = deptDao.loadByName(name);
		if (dept == null) {
			return false;
		}
		return true;
	}

	@Override
	public Dept load(int id) {
		return deptDao.load(id);
	}

	@Override
	public void update(Dept dept) {
		deptDao.update(dept);
	}

}
