package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.IPaymentDao;
import com.tledu.wyb.model.Payment;
import com.tledu.wyb.service.IPaymentService;
@Service
public class PaymentService implements IPaymentService{
	@Autowired
	private IPaymentDao paymentDao;
	@Override
	public List<Payment> list() {
		return paymentDao.list();
	}

	@Override
	public void add(Payment payment) {
		paymentDao.add(payment);
		
	}

	@Override
	public boolean verifytheme(String theme) {
		Payment payment = paymentDao.loadBytheme(theme);
		if (payment == null) {
			return false;
		}
		return true;
	}

	@Override
	public void delete(int id) {
		paymentDao.delete(id);
		
	}

	@Override
	public Payment load(int id) {
		return paymentDao.load(id);
	}

	@Override
	public void update(Payment payment) {
		paymentDao.update(payment);
	}

}
