package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.IQualityDao;
import com.tledu.wyb.model.Quality;
import com.tledu.wyb.service.IQualityService;
@Service
public class QualityService implements IQualityService{
	@Autowired
	private IQualityDao qualityDao;
	@Override
	public List<Quality> list() {
		return qualityDao.list();
	}

	@Override
	public void add(Quality quality) {
		qualityDao.add(quality);
		
	}

	@Override
	public boolean verifyQualityTheme(String qualityTheme) {
		Quality quality = qualityDao.loadByQualityTheme(qualityTheme);
		if (quality == null) {
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		qualityDao.delete(id);
		
	}

	@Override
	public Quality load(int id) {
		return qualityDao.load(id);
	}

	@Override
	public void update(Quality quality) {
		qualityDao.update(quality);
		
	}

}
