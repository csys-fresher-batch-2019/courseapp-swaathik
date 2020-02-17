package manage.CourseEnroll;

import java.sql.SQLException;

import com.student.CourseEnroll.CourseEnrollImpl;

public class TestCourseEnroll1 {
	public static void main(String[] args) throws SQLException {
		CourseEnrollImpl course = new CourseEnrollImpl();
		course.display();
	}
	}
