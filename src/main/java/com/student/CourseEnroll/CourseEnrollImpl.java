package com.student.CourseEnroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;
import com.student.course.CourseClass;

public class CourseEnrollImpl implements CourseEnrollDAO {
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addCourses(CourseEnrollClass course) {
		String sql = "insert into courseEnroll(adm_no,email_id,course_name)values(?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, course.getAdmNo());
			pst.setString(2,course.getEmailId());
			pst.setString(3, course.getCourseName());

			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}


	@Override
	public List<CourseEnrollClass> display() throws SQLException {
		List<CourseEnrollClass> c = new ArrayList<>();
		String sql = "select adm_no,email_id,course_name from courseEnroll";
		try(Connection connection = ConnectionUtil.getConnection();
				Statement stmt = connection.createStatement()) {
			try(ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				int admNo = rs.getInt("adm_no");
				LOGGER.debug("Admission Number : "+admNo);
				String emailId = rs.getString("email_id");
				LOGGER.debug("Email Id : "+emailId);
				String courseName = rs.getString("course_name");
				LOGGER.debug("CourseName : "+courseName);
		
				CourseEnrollClass course = new CourseEnrollClass();
				course.setAdmNo(admNo);
				course.setEmailId(emailId);
				course.setCourseName(courseName);
				c.add(course);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return c;
	}
}
}