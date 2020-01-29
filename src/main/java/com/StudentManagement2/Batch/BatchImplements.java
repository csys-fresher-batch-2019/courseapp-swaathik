package com.StudentManagement2.Batch;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.StudentManagement2.Basics.Logger;

public class BatchImplements implements BatchDAO {
	private static Logger LOGGER = Logger.getInstance();
	public void addBatches(BatchClass batch) throws Exception {
		String sql = "insert into Batches(batch_code,course_code,starting_date,end_date) values(?,?,?,?)";
		//Step 1:Get the Connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, batch.getBatchCode());
		pst.setInt(2, batch.getCourseCode());
		
		//LocalDate startingDate = null;
		//pst.setDate(3,java.sql.Date.valueOf(startingDate));
		//LocalDate endDate = null;
		//pst.setDate(4,java.sql.Date.valueOf(endDate));
		Date startDate = Date.valueOf(batch.getStartingDate());
		pst.setDate(3,startDate);
		pst.setDate(4, Date.valueOf(batch.getEndDate()));
		//Step 3:Execute the Query
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted : "+rows);
	}
	public void deleteBatches(int batchCode) throws Exception{
		String sql = "delete from batches where batch_code = ?";
		//Step 1:Get the Connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1,batchCode);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted : "+rows);
	}
	public void updateBatches(int courseCode) throws Exception {
		String sql = "update batches set batch_code=121 where course_code=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1,courseCode);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows updated : "+rows);
		
		
	}

	public List<BatchClass> displayBatchCodeCourseCode()  throws Exception {
		List<BatchClass> b = new ArrayList<BatchClass>();
		String sql = "select batch_code,course_code from batches";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int batchCode = rs.getInt("batch_code");
			int courseCode = rs.getInt("course_code");
			LOGGER.debug("Batch Code : "+batchCode+" "+"Course Code : "+courseCode);
			BatchClass batch = new BatchClass();
			batch.setBatchCode(batchCode);
			batch.setCourseCode(courseCode);
			b.add(batch);
		}
		return null;
	}


	
	

}
