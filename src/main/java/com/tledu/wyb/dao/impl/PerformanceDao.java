package com.tledu.wyb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.IPerformanceDao;
import com.tledu.wyb.model.Performance;
import com.tledu.wyb.util.DBUtil;
@Repository
public class PerformanceDao implements IPerformanceDao{

	@Override
	public List<Performance> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_performance order by id asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Performance> performances = new ArrayList<Performance>();
			while (resultSet.next()) {
				Performance performance = new Performance(resultSet.getInt("id"),
						resultSet.getString("progTheme"),
						resultSet.getString("creater"),
						resultSet.getString("createDate"));
				performances.add(performance);
			}
			return performances;
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
	public List<Performance> list(String progTheme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			// 如果多个表中,列名重复,注意使用别名来区别
			String sql = "select * from t_performance where progTheme like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+progTheme+"%");
			resultSet = preparedStatement.executeQuery();
			List<Performance> performances = new ArrayList<Performance>();
			while (resultSet.next()) {
				Performance performance = new Performance(resultSet.getInt("id"),
						resultSet.getString("progTheme"),
						resultSet.getString("creater"),
						resultSet.getString("createDate"));
				performances.add(performance);
			}
			return performances;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return null;
	}

	@Override
	public void add(Performance performance) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_performance (progTheme,creater,createDate) values (?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, performance.getProgTheme());
			preparedStatement.setString(2, performance.getCreater());
			preparedStatement.setString(3, performance.getCreateDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}

	@Override
	public Performance loadByprogTheme(String progTheme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_performance where progTheme = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, progTheme);
			resultSet = preparedStatement.executeQuery();
			Performance performance = null;
			if (resultSet.next()) {
				 performance = new Performance(resultSet.getInt("id"),
						resultSet.getString("progTheme"),
						resultSet.getString("creater"),
						resultSet.getString("createDate"));
			}
			return performance;
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
			String sql = "delete from t_performance where id=?";
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
	public Performance load(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_performance where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Performance performance = null;
			if (resultSet.next()) {
				performance = new Performance(resultSet.getInt("id"),
						resultSet.getString("progTheme"),
						resultSet.getString("creater"),
						resultSet.getString("createDate"));
			}
			return performance;
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
	public void update(Performance performance) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_performance set progTheme=?, creater=?, createDate=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, performance.getProgTheme());
			preparedStatement.setString(2, performance.getCreater());
			preparedStatement.setString(3, performance.getCreateDate());
			preparedStatement.setInt(4, performance.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}

}
