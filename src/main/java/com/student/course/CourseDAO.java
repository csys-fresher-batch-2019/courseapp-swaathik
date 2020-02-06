package com.student.course;

import java.util.List;

public interface CourseDAO {
	//insert into courses course_code,course_name,course_fee,course_duration_days,pre_req
	void addCourses(CourseClass course) throws Exception;
	
	//update courses set course_duration_weeks=? where course_code=?
	void updateCourses(int courseCode) throws Exception;
	
	//delete from courses where course_code=?
	void deleteCourses(int courseCode) throws Exception;
	
	//select course_name from courses where course_code=?
	List<CourseClass> orderByCourseName() throws Exception;
	//select course_fee from courses where course_code=? 
	int getCourseFees(int course_code) throws Exception; 
	
  
	

}
