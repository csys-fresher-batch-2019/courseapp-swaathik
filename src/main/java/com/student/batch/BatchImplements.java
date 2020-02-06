package com.student.batch;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;


public class BatchImplements implements BatchDAO {
	private static Logger LOGGER = Logger.getInstance();
	public void addBatches(BatchClass batch) {
		String sql = "insert into Batches(batch_code,course_code,course_name,starting_date,end_date) values(?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, batch.getBatchCode());
			pst.setInt(2, batch.getCourseCode());
			pst.setString(3, batch.getCourseName());
			Date startDate = Date.valueOf(batch.getStartingDate());
			pst.setDate(4,startDate);
			pst.setDate(5, Date.valueOf(batch.getEndDate()));
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}
	public void deleteBatches(int batchCode) {
		String sql = "delete from batches where batch_code = ?";
		try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement pst = connection.prepareStatement(sql);)		
		{
			pst.setInt(1,batchCode);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}
	public void updateBatches(int courseCode) {
		String sql = "update batches set batch_code=121 where course_code=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			LOGGER.info(sql);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows updated : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
		
	}

	public List<BatchClass> displayBatchCodeCourseCode() {
		List<BatchClass> b = new ArrayList<>();
		String sql = "select batch_code,course_code,course_name from batches";
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				int batchCode = rs.getInt("batch_code");
				int courseCode = rs.getInt("course_code");
				String courseName = rs.getString("course_name");
				LOGGER.info("Batch Code : "+batchCode+" "+"Course Code : "+courseCode+"Course Name : "+courseName);
				BatchClass batch = new BatchClass();
				batch.setBatchCode(batchCode);
				batch.setCourseCode(courseCode);
				batch.setCourseName(courseName);
				b.add(batch);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return b;
	}
}
