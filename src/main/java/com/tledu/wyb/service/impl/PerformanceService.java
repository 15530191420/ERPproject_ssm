package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.IPerformanceDao;
import com.tledu.wyb.model.Performance;
import com.tledu.wyb.service.IPerformanceService;
@Service
public class PerformanceService implements IPerformanceService{
	@Autowired
	private IPerformanceDao performanceDao;
	@Override
	public List<Performance> list() {
		return performanceDao.list();
	}

	@Override
	public void add(Performance performance) {
		performanceDao.add(performance);
		
	}

	@Override
	public boolean verifyProgTheme(String progTheme) {
		Performance performance = performanceDao.loadByprogTheme(progTheme);
		if (performance == null) {
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		performanceDao.delete(id);
		
	}

	@Override
	public Performance load(int id) {
		return performanceDao.load(id);
	}

	@Override
	public void update(Performance performance) {
		performanceDao.update(performance);
	}

}
