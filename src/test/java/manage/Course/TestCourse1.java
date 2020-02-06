package manage.Course;
import com.student.course.CourseDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

import java.util.Scanner;
public class TestCourse1 {
	private static Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Course Code : ");
		int courseCode = in.nextInt();
		//CourseImplements c3 = new CourseImplements();
		//c3.deleteCourses(courseCode);
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.deleteCourses(courseCode);
		in.close();
	}

}
