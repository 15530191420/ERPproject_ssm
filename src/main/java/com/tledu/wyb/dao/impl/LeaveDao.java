package com.tledu.wyb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.ILeaveDao;
import com.tledu.wyb.model.Leave;
import com.tledu.wyb.util.DBUtil;

@Repository
public class LeaveDao implements ILeaveDao {

	@Override
	public List<Leave> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_leave order by id asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Leave> leaves = new ArrayList<Leave>();
			while (resultSet.next()) {
				Leave leave = new Leave(resultSet.getInt("id"),
						resultSet.getString("leavename"),
						resultSet.getString("startDate"),
						resultSet.getString("belongDept"),
						resultSet.getString("post"),
						resultSet.getString("arrivalDate"));
				leaves.add(leave);
			}
			return leaves;
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
			String sql = "delete from t_leave where id=?";
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
	public void add(Leave leave) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_leave ( leavename, startDate, belongDept, post, arrivalDate) values (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, leave.getLeavename());
			preparedStatement.setString(2, leave.getStartDate());
			preparedStatement.setString(3, leave.getBelongDept());
			preparedStatement.setString(4, leave.getPost());
			preparedStatement.setString(5, leave.getArrivalDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public Leave loadByLeavename(String leavename) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_leave where leavename = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, leavename);
			resultSet = preparedStatement.executeQuery();
			Leave leave = null;
			if (resultSet.next()) {
				leave = new Leave(resultSet.getInt("id"),
						resultSet.getString("leavename"),
						resultSet.getString("startDate"),
						resultSet.getString("belongDept"),
						resultSet.getString("post"),
						resultSet.getString("arrivalDate"));
			}
			return leave;
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
	public Leave load(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_leave where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Leave leave = null;
			if (resultSet.next()) {
				leave = new Leave(resultSet.getInt("id"),
						resultSet.getString("leavename"),
						resultSet.getString("startDate"),
						resultSet.getString("belongDept"),
						resultSet.getString("post"),
						resultSet.getString("arrivalDate"));
			}
			return leave;
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
	public void update(Leave leave) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_leave set leavename=?, startDate=?, belongDept=?, post=?, arrivalDate=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, leave.getLeavename());
			preparedStatement.setString(2, leave.getStartDate());
			preparedStatement.setString(3, leave.getBelongDept());
			preparedStatement.setString(4, leave.getPost());
			preparedStatement.setString(5, leave.getArrivalDate());
			preparedStatement.setInt(6, leave.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public List<Leave> list(String leavename) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			// 如果多个表中,列名重复,注意使用别名来区别
			String sql = "select * from t_leave where leavename like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+leavename+"%");
			System.out.println(leavename);
			resultSet = preparedStatement.executeQuery();
			List<Leave> leaves = new ArrayList<Leave>();
			while (resultSet.next()) {
				Leave leave = new Leave(resultSet.getInt("id"),
						resultSet.getString("leavename"),
						resultSet.getString("startDate"),
						resultSet.getString("belongDept"),
						resultSet.getString("post"),
						resultSet.getString("arrivalDate"));
				leaves.add(leave);
			}
			return leaves;
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
