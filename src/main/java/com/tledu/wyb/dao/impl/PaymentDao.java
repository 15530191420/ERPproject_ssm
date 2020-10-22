package com.tledu.wyb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.IPaymentDao;
import com.tledu.wyb.model.Payment;
import com.tledu.wyb.model.Transfer;
import com.tledu.wyb.model.User;
import com.tledu.wyb.util.DBUtil;

@Repository
public class PaymentDao implements IPaymentDao{

	@Override
	public List<Payment> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_payment order by id asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Payment> payments = new ArrayList<Payment>();
			while (resultSet.next()) {
				Payment payment = new Payment(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("month"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("editor"),
						resultSet.getString("editorDate"));
				payments.add(payment);
			}
			return payments;
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
	public void add(Payment payment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_payment (theme,month,startDate,endDate,editor,editorDate) values (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, payment.getTheme());
			preparedStatement.setString(2, payment.getMonth());
			preparedStatement.setString(3, payment.getStartDate());
			preparedStatement.setString(4, payment.getEndDate());
			preparedStatement.setString(5, payment.getEditor());
			preparedStatement.setString(6, payment.getEditorDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}

	@Override
	public Payment loadBytheme(String theme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_payment where theme = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, theme);
			resultSet = preparedStatement.executeQuery();
			Payment payment = null;
			if (resultSet.next()) {
				payment = new Payment(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("month"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("editor"),
						resultSet.getString("editorDate"));
			}
			return payment;
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
			String sql = "delete from t_payment where id=?";
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
	public Payment load(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_payment where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Payment payment = null;
			if (resultSet.next()) {
				payment = new Payment(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("month"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("editor"),
						resultSet.getString("editorDate"));
			}
			return payment;
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
	public void update(Payment payment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_payment set theme=?, month=?, startDate=?, endDate=?, editor=?, editorDate=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, payment.getTheme());
			preparedStatement.setString(2, payment.getMonth());
			preparedStatement.setString(3, payment.getStartDate());
			preparedStatement.setString(4, payment.getEndDate());
			preparedStatement.setString(5, payment.getEditor());
			preparedStatement.setString(6, payment.getEditorDate());
			preparedStatement.setInt(7, payment.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}

	@Override
	public List<Payment> list(String theme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			// 如果多个表中,列名重复,注意使用别名来区别
			String sql = "select * from t_payment where theme like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+theme+"%");
			resultSet = preparedStatement.executeQuery();
			List<Payment> payments = new ArrayList<Payment>();
			while (resultSet.next()) {
				Payment payment = new Payment(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("month"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("editor"),
						resultSet.getString("editorDate"));
				payments.add(payment);
			}
			return payments;
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
