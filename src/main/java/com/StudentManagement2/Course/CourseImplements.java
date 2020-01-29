package com.StudentManagement2.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.StudentManagement2.Basics.Logger;

public class CourseImplements implements CourseDAO{
	private static Logger LOGGER = Logger.getInstance();
	public void addCourses(CourseClass course) throws Exception {
		String sql = "insert into courses (course_code,course_name,course_fee,course_duration_days,pre_req) values(?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, course.getCourseCode());
		pst.setString(2,course.getCourseName());
		pst.setInt(3, course.getCourseFee());
		pst.setInt(4, course.getCourseDurationDays());
		pst.setString(5, course.getPreReq());
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted : "+rows);
		
	}

	public void updateCourses(int courseCode) throws Exception {
		String sql = "update courses set course_duration_days=45 where course_code=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1,courseCode);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows Updated : "+rows);
		
	}

	public void deleteCourses(int courseCode) throws Exception {
		String sql = "delete from courses where course_code=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1,courseCode);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted : "+rows);
	}

	public List<CourseClass> orderByCourseName() throws Exception {
		List<CourseClass> c = new ArrayList<CourseClass>();
		String sql = "select course_name,course_code from courses order by course_name";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String courseName = rs.getString("course_name");
			LOGGER.debug("Course Name : "+courseName);
			int courseCode = rs.getInt("course_code");
			System.out.println("Course Code : "+courseCode);
			CourseClass course = new CourseClass();
			course.setCourseName(courseName);
			course.setCourseCode(courseCode);;
			c.add(course);
		}
		return c;
	}

}
