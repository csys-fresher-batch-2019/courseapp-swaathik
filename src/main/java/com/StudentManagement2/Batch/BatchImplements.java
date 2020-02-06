package com.StudentManagement2.Batch;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.StudentManagement2.Basics.ConnectionUtil;

public class BatchImplements implements BatchDAO {
	public void addBatches(BatchClass batch) throws Exception {
		String sql = "insert into Batches(batch_code,course_code,course_name,starting_date,end_date) values(?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, batch.getBatchCode());
			pst.setInt(2, batch.getCourseCode());
			pst.setString(3, batch.getCourseName());
			//LocalDate startingDate = null;
			//pst.setDate(3,java.sql.Date.valueOf(startingDate));
			//LocalDate endDate = null;
			//pst.setDate(4,java.sql.Date.valueOf(endDate));
			Date startDate = Date.valueOf(batch.getStartingDate());
			pst.setDate(4,startDate);
			pst.setDate(5, Date.valueOf(batch.getEndDate()));
			
			//Step 3:Execute the Query
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted : "+rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBatches(int batchCode) throws Exception{
		String sql = "delete from batches where batch_code = ?";
		try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement pst = connection.prepareStatement(sql);)		
		{
			pst.setInt(1,batchCode);
			System.out.println(sql);
			int rows = pst.executeUpdate();
			System.out.println("No of rows deleted : "+rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateBatches(int courseCode) throws Exception {
		String sql = "update batches set batch_code=121 where course_code=?";
		
		//Step 2: Prepare the Query
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			System.out.println(sql);
			int rows = pst.executeUpdate();
			System.out.println("No of rows updated : "+rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<BatchClass> displayBatchCodeCourseCode()  throws Exception {
		List<BatchClass> b = new ArrayList<>();
		String sql = "select batch_code,course_code,course_name from batches";
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				int batchCode = rs.getInt("batch_code");
				int courseCode = rs.getInt("course_code");
				String courseName = rs.getString("course_name");
				System.out.println("Batch Code : "+batchCode+" "+"Course Code : "+courseCode+"Course Name : "+courseName);
				BatchClass batch = new BatchClass();
				batch.setBatchCode(batchCode);
				batch.setCourseCode(courseCode);
				batch.setCourseName(courseName);
				b.add(batch);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}


	
	

}
