package com.tledu.wyb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.IEvaluationDao;
import com.tledu.wyb.dao.IPaymentDao;
import com.tledu.wyb.model.Evaluation;
import com.tledu.wyb.model.Payment;
import com.tledu.wyb.model.Transfer;
import com.tledu.wyb.model.User;
import com.tledu.wyb.util.DBUtil;

@Repository
public class EvaluationDao implements IEvaluationDao{

	@Override
	public List<Evaluation> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_evaluation order by id asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Evaluation> evaluations = new ArrayList<Evaluation>();
			while (resultSet.next()) {
				Evaluation evaluation = new Evaluation(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("circleSort"),
						resultSet.getString("checkCircle"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("creatDate"));
				evaluations.add(evaluation);
			}
			return evaluations;
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
	public void add(Evaluation evaluation) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_evaluation (theme,circleSort,checkCircle,startDate,endDate,creatDate) values (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, evaluation.getTheme());
			preparedStatement.setString(2, evaluation.getCircleSort());
			preparedStatement.setString(3, evaluation.getCheckCircle());
			preparedStatement.setString(4, evaluation.getStartDate());
			preparedStatement.setString(5, evaluation.getEndDate());
			preparedStatement.setString(6, evaluation.getCreatDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}

	@Override
	public Evaluation loadBytheme(String theme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_evaluation where theme = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, theme);
			resultSet = preparedStatement.executeQuery();
			Evaluation evaluation = null;
			if (resultSet.next()) {
				 evaluation = new Evaluation(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("circleSort"),
						resultSet.getString("checkCircle"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("creatDate"));
			}
			return evaluation;
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
			String sql = "delete from t_evaluation where id=?";
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
	public Evaluation load(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_evaluation where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Evaluation evaluation = null;
			if (resultSet.next()) {
				evaluation = new Evaluation(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("circleSort"),
						resultSet.getString("checkCircle"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("creatDate"));
			}
			return evaluation;
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
	public void update(Evaluation evaluation) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_evaluation set theme=?, circleSort=?, checkCircle=?, startDate=?, endDate=?, creatDate=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, evaluation.getTheme());
			preparedStatement.setString(2, evaluation.getCircleSort());
			preparedStatement.setString(3, evaluation.getCheckCircle());
			preparedStatement.setString(4, evaluation.getStartDate());
			preparedStatement.setString(5, evaluation.getEndDate());
			preparedStatement.setString(6, evaluation.getCreatDate());
			preparedStatement.setInt(7, evaluation.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
	}

	@Override
	public List<Evaluation> list(String theme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			// 如果多个表中,列名重复,注意使用别名来区别
			String sql = "select * from t_evaluation where theme like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+theme+"%");
			resultSet = preparedStatement.executeQuery();
			List<Evaluation> evaluations = new ArrayList<Evaluation>();
			while (resultSet.next()) {
				Evaluation evaluation = new Evaluation(resultSet.getInt("id"),
						resultSet.getString("theme"),
						resultSet.getString("circleSort"),
						resultSet.getString("checkCircle"),
						resultSet.getString("startDate"),
						resultSet.getString("endDate"),
						resultSet.getString("creatDate"));
				evaluations.add(evaluation);
			}
			return evaluations;
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
