package com.StudentManagement2.Course;

import java.util.List;

public interface CourseDAO {
	//insert into courses course_code,course_name,course_fee,course_duration_days,pre_req
	void addCourses(CourseClass course) throws Exception;
	
	//update courses set course_duration_weeks=? where course_code=?
	void updateCourses(int courseCode) throws Exception;
	
	//delete from courses where course_code=?
	void deleteCourses(int courseCode) throws Exception;
	
	//select course_name,course_code from courses order by course_name
	List<CourseClass> orderByCourseName() throws Exception;
	

}
