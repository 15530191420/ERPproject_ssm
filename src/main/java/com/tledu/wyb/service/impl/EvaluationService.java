package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.IEvaluationDao;
import com.tledu.wyb.model.Evaluation;
import com.tledu.wyb.service.IEvaluationService;
@Service
public class EvaluationService implements IEvaluationService{
	@Autowired
	private IEvaluationDao evaluationDao;
	@Override
	public List<Evaluation> list() {
		return evaluationDao.list();
	}

	@Override
	public void add(Evaluation evaluation) {
		evaluationDao.add(evaluation);
		
	}

	@Override
	public boolean verifytheme(String theme) {
		Evaluation evaluation = evaluationDao.loadBytheme(theme);
		if (evaluation == null) {
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		evaluationDao.delete(id);
		
	}

	@Override
	public Evaluation load(int id) {
		return evaluationDao.load(id);
	}

	@Override
	public void update(Evaluation evaluation) {
		evaluationDao.update(evaluation);
	}

}
