package com.student.course;

import java.util.List;


public interface CourseDAO {
	
	
	void addCourses( CourseClass course) ;
	
	
	
	void updateCourses(int courseCode) ;
	
	
	
	void deleteCourses(int courseCode) ;
	
	
	
	List<CourseClass> orderByCourseName();
	 
	
	
	List<CourseClass> orderBy(String courseName) ;
  
	

}
