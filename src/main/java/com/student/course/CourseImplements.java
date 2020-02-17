package com.student.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;

public class CourseImplements implements CourseDAO{
	private static final Logger LOGGER = Logger.getInstance();
	public void addCourses(CourseClass course) {
		String sql = "insert into courses (course_code,course_name,course_fee,course_duration_days,pre_req) values(?,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, course.getCourseCode());
			pst.setString(2,course.getCourseName());
			pst.setInt(3, course.getCourseFee());
			pst.setInt(4, course.getCourseDurationDays());
			pst.setString(5, course.getPreReq());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}

	public void updateCourses(int courseCode)  {
		String sql = "update courses set course_duration_days=45 where course_code=?";
		
		
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows Updated : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}

	public void deleteCourses(int courseCode) {
		String sql = "delete from courses where course_code=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,courseCode);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}

	public List<CourseClass> orderByCourseName()  {
		
		List<CourseClass> c = new ArrayList<>();
		String sql = "select course_name,course_code,course_fee,course_duration_days,pre_req,course_image from courses";
		
		
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				String cName = rs.getString("course_name");
				LOGGER.debug("Course Name : "+cName);
				int courseCode = rs.getInt("course_code");
				LOGGER.debug("Course Code : "+courseCode);
				int courseFee = rs.getInt("course_fee");
				LOGGER.debug("Course Fee : "+courseFee);
				int courseDurationDays = rs.getInt("course_duration_days");
				LOGGER.debug("Course Duration(days) : "+courseDurationDays);
				String preReq = rs.getString("pre_req");
				LOGGER.debug("Pre Requisite : "+preReq);
				String courseImage = rs.getString("course_image");
				LOGGER.debug("Course Image : "+courseImage);
				
				CourseClass course = new CourseClass();
				course.setCourseName(cName);
				course.setCourseCode(courseCode);
				course.setCourseFee(courseFee);
				course.setCourseDurationDays(courseDurationDays);
				course.setPreReq(preReq);
				course.setCourse_image(courseImage);
				c.add(course);
			}
		} 
		catch (Exception e) {
			LOGGER.debug(e);
		}
		return c;
	}

	@Override
	public List<CourseClass> orderBy(String courseName)  {
		List<CourseClass> list = new ArrayList<>();
		String sql = "select course_name,course_fee,course_duration_days,pre_req from courses where course_name=?";	
		try(Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql)){
		pst.setString(1, courseName);
		try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					String courseName1 = rs.getString("course_name");
					LOGGER.debug(courseName1);
					 int courseFee = rs.getInt("course_fee");
					LOGGER.debug(courseFee);
					int courseDurationDays = rs.getInt("course_duration_days");
					LOGGER.debug(courseDurationDays);
					String preReq = rs.getString("pre_Req");
					LOGGER.debug(preReq);
					CourseClass course = new CourseClass();
					course.setCourseFee(courseFee);
					course.setCourseDurationDays(courseDurationDays);
					course.setPreReq(preReq);
					list.add(course);
				}
		}
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
	  		return list;
	}

	public int getCourseFee(int courseCode) {
		int courseFee=0;
		List<CourseClass> list = new ArrayList<>();
		String sql = "select course_fee from courses where course_code=?";	
		try(Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql)){
		pst.setInt(1, courseCode);
		try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					 courseFee = rs.getInt("course_fee");
					LOGGER.debug(courseFee);
					CourseClass course = new CourseClass();
					course.setCourseFee(courseFee);
					list.add(course);
				}
		}
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
	  		return courseFee;
	}
}
