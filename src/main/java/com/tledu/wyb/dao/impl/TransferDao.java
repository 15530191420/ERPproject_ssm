package com.tledu.wyb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.ITransferDao;
import com.tledu.wyb.model.Transfer;
import com.tledu.wyb.util.DBUtil;

@Repository
public class TransferDao implements ITransferDao {

	@Override
	public List<Transfer> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_transfer order by id asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Transfer> transfers = new ArrayList<Transfer>();
			while (resultSet.next()) {
				Transfer transfer = new Transfer(resultSet.getInt("id"),
						resultSet.getString("applyname"),
						resultSet.getString("applyDate"),
						resultSet.getString("currentDept"),
						resultSet.getString("currentPosition"),
						resultSet.getString("currentLevel"),
						resultSet.getString("hopeDate"),
						resultSet.getString("targetDept"),
						resultSet.getString("tatgetPosition"),
						resultSet.getString("targetLevel"));
				transfers.add(transfer);
			}
			return transfers;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return null;
	}

	@Override
	public void add(Transfer transfer) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_transfer (applyname,applyDate,currentDept,currentPosition,currentLevel,hopeDate,targetDept,tatgetPosition,targetLevel) values (?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, transfer.getApplyname());
			preparedStatement.setString(2, transfer.getApplyDate());
			preparedStatement.setString(3, transfer.getCurrentDept());
			preparedStatement.setString(4, transfer.getCurrentPosition());
			preparedStatement.setString(5, transfer.getCurrentLevel());
			preparedStatement.setString(6, transfer.getHopeDate());
			preparedStatement.setString(7, transfer.getTargetDept());
			preparedStatement.setString(8, transfer.getTatgetPosition());
			preparedStatement.setString(9, transfer.getTargetLevel());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public Transfer loadByApplyname(String applyname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_transfer where applyname = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, applyname);
			resultSet = preparedStatement.executeQuery();
			Transfer transfer = null;
			if (resultSet.next()) {
				transfer = new Transfer(resultSet.getInt("id"),
						resultSet.getString("applyname"),
						resultSet.getString("applyDate"),
						resultSet.getString("currentDept"),
						resultSet.getString("currentPosition"),
						resultSet.getString("currentLevel"),
						resultSet.getString("hopeDate"),
						resultSet.getString("targetDept"),
						resultSet.getString("tatgetPosition"),
						resultSet.getString("targetLevel"));
			}
			return transfer;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return null;
	}

	@Override
	public void delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "delete from t_transfer where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public Transfer load(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_transfer where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Transfer transfer = null;
			if (resultSet.next()) {
				transfer = new Transfer(resultSet.getInt("id"),
						resultSet.getString("applyname"),
						resultSet.getString("applyDate"),
						resultSet.getString("currentDept"),
						resultSet.getString("currentPosition"),
						resultSet.getString("currentLevel"),
						resultSet.getString("hopeDate"),
						resultSet.getString("targetDept"),
						resultSet.getString("tatgetPosition"),
						resultSet.getString("targetLevel"));
			}
			return transfer;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return null;
	}

	@Override
	public void update(Transfer transfer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_transfer set applyname=?, applyDate=?, currentDept=?, currentPosition=?, currentLevel=?, hopeDate=?, targetDept=?, tatgetPosition=?, targetLevel=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, transfer.getApplyname());
			preparedStatement.setString(2, transfer.getApplyDate());
			preparedStatement.setString(3, transfer.getCurrentDept());
			preparedStatement.setString(4, transfer.getCurrentPosition());
			preparedStatement.setString(5, transfer.getCurrentLevel());
			preparedStatement.setString(6, transfer.getHopeDate());
			preparedStatement.setString(7, transfer.getTargetDept());
			preparedStatement.setString(8, transfer.getTatgetPosition());
			preparedStatement.setString(9, transfer.getTargetLevel());
			preparedStatement.setInt(10, transfer.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public List<Transfer> list(String applyname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			// 如果多个表中,列名重复,注意使用别名来区别
			String sql = "select * from t_transfer where applyname like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+applyname+"%");
			resultSet = preparedStatement.executeQuery();
			List<Transfer> transfers = new ArrayList<Transfer>();
			while (resultSet.next()) {
				Transfer transfer = new Transfer(resultSet.getInt("id"),
						resultSet.getString("applyname"),
						resultSet.getString("applyDate"),
						resultSet.getString("currentDept"),
						resultSet.getString("currentPosition"),
						resultSet.getString("currentLevel"),
						resultSet.getString("hopeDate"),
						resultSet.getString("targetDept"),
						resultSet.getString("tatgetPosition"),
						resultSet.getString("targetLevel"));
				transfers.add(transfer);
			}
			return transfers;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return null;
	}

}
