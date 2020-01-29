package manage.Course;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Course.CourseDAO;

import java.util.Scanner;

public class TestCourse2 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter CourseCode: ");
		int courseCode = in.nextInt();
		//CourseImplements c2 = new CourseImplements();
		//c2.updateCourses(courseCode);
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.updateCourses(courseCode);
		in.close();
	}

}
