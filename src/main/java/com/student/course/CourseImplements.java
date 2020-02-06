package com.student.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;

public class CourseImplements implements CourseDAO{
	private static Logger LOGGER = Logger.getInstance();
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
		String sql = "select course_name,course_code from courses order by course_name";
		
		
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			
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
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return c;
	}
}

//	public int getCourseFees(int courseCode) throws Exception {
//		int courseFee = 0;
//		 String sql = "select course_fee from courses where course_code=?";
//		    
//		  		
//		  		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);ResultSet rs = pst.executeQuery();) {
//					pst.setInt(1, courseCode);
//					
//					while(rs.next()) {
//						 courseFee = rs.getInt("course_fee");
//						LOGGER.debug(courseFee);
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		  		return courseFee;
//	}
//}
