package manage.Course;

import com.student.course.CourseDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

import java.util.Scanner;

public class TestCourse2 {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter CourseCode: ");
		int courseCode = in.nextInt();
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.updateCourses(courseCode);
		in.close();
	}

}
