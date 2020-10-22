package com.tledu.wyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tledu.wyb.dao.ITransferDao;
import com.tledu.wyb.model.Transfer;
import com.tledu.wyb.service.ITransferService;
@Service
public class TransferService implements ITransferService{
	@Autowired
	private ITransferDao transferDao;
	@Override
	public List<Transfer> list() {
		return transferDao.list();
	}
	@Override
	public void add(Transfer transfer) {
		transferDao.add(transfer);
		
	}
	@Override
	public boolean verifyApplyname(String applyname) {
		Transfer transfer = transferDao.loadByApplyname(applyname);
		if (transfer == null) {
			return false;
		}
		return true;
	}
	@Override
	public void delete(int id) {
		transferDao.delete(id);
		
	}
	@Override
	public Transfer load(int id) {
		return transferDao.load(id);
	}
	@Override
	public void update(Transfer transfer) {
		transferDao.update(transfer);
	}

}
