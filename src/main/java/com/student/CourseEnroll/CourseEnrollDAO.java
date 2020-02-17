package com.student.CourseEnroll;

import java.sql.SQLException;
import java.util.List;


public interface CourseEnrollDAO {
	void addCourses(CourseEnrollClass course) ;
	List<CourseEnrollClass> display() throws SQLException;

}
