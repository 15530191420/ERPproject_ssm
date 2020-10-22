package com.tledu.wyb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tledu.wyb.dao.IQualityDao;
import com.tledu.wyb.model.Payment;
import com.tledu.wyb.model.Quality;
import com.tledu.wyb.util.DBUtil;

@Repository
public class QualityDao implements IQualityDao {

	@Override
	public List<Quality> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_quality order by id asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Quality> qualities = new ArrayList<Quality>();
			while (resultSet.next()) {
				Quality quality = new Quality(resultSet.getInt("id"),
						resultSet.getString("qualityTheme"),
						resultSet.getString("originalType"),
						resultSet.getString("currentUnits"),
						resultSet.getString("categ"),
						resultSet.getString("inspectionMethods"),
						resultSet.getString("inspectionPersonnel"),
						resultSet.getString("inspectionDept"),
						resultSet.getString("inspectionDate"));
				qualities.add(quality);
			}
			return qualities;
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
	public List<Quality> list(String qualityTheme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			// 如果多个表中,列名重复,注意使用别名来区别
			String sql = "select * from t_quality where qualityTheme like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+qualityTheme+"%");
			resultSet = preparedStatement.executeQuery();
			List<Quality> qualities = new ArrayList<Quality>();
			while (resultSet.next()) {
				Quality quality = new Quality(resultSet.getInt("id"),
						resultSet.getString("qualityTheme"),
						resultSet.getString("originalType"),
						resultSet.getString("currentUnits"),
						resultSet.getString("categ"),
						resultSet.getString("inspectionMethods"),
						resultSet.getString("inspectionPersonnel"),
						resultSet.getString("inspectionDept"),
						resultSet.getString("inspectionDate"));
				qualities.add(quality);
			}
			return qualities;
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
	public void add(Quality quality) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into t_quality (qualityTheme,originalType,currentUnits,categ,inspectionMethods,inspectionPersonnel,inspectionDept,inspectionDate) values (?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, quality.getQualityTheme());
			preparedStatement.setString(2, quality.getOriginalType());
			preparedStatement.setString(3, quality.getCurrentUnits());
			preparedStatement.setString(4, quality.getCateg());
			preparedStatement.setString(5, quality.getInspectionMethods());
			preparedStatement.setString(6, quality.getInspectionPersonnel());
			preparedStatement.setString(7, quality.getInspectionDept());
			preparedStatement.setString(8, quality.getInspectionDate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

	@Override
	public Quality loadByQualityTheme(String qualityTheme) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_quality where qualityTheme = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, qualityTheme);
			resultSet = preparedStatement.executeQuery();
			Quality quality = null;
			if (resultSet.next()) {
				 quality = new Quality(resultSet.getInt("id"),
						resultSet.getString("qualityTheme"),
						resultSet.getString("originalType"),
						resultSet.getString("currentUnits"),
						resultSet.getString("categ"),
						resultSet.getString("inspectionMethods"),
						resultSet.getString("inspectionPersonnel"),
						resultSet.getString("inspectionDept"),
						resultSet.getString("inspectionDate"));
			}
			return quality;
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
			String sql = "delete from t_quality where id=?";
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
	public Quality load(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from t_quality where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Quality quality = null;
			if (resultSet.next()) {
				 quality = new Quality(resultSet.getInt("id"),
						resultSet.getString("qualityTheme"),
						resultSet.getString("originalType"),
						resultSet.getString("currentUnits"),
						resultSet.getString("categ"),
						resultSet.getString("inspectionMethods"),
						resultSet.getString("inspectionPersonnel"),
						resultSet.getString("inspectionDept"),
						resultSet.getString("inspectionDate"));
			}
			return quality;
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
	public void update(Quality quality) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "update t_quality set qualityTheme=?, originalType=?, currentUnits=?, categ=?, inspectionMethods=?, inspectionPersonnel=?, inspectionDept=?, inspectionDate=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, quality.getQualityTheme());
			preparedStatement.setString(2, quality.getOriginalType());
			preparedStatement.setString(3, quality.getCurrentUnits());
			preparedStatement.setString(4, quality.getCateg());
			preparedStatement.setString(5, quality.getInspectionMethods());
			preparedStatement.setString(6, quality.getInspectionPersonnel());
			preparedStatement.setString(7, quality.getInspectionDept());
			preparedStatement.setString(8, quality.getInspectionDate());
			preparedStatement.setInt(9, quality.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}

	}

}
