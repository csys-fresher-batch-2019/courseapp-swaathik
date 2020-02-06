package manage.Course;
import java.util.Scanner;

import com.student.course.CourseClass;
import com.student.course.CourseDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

public class TestCourse {
	private static final Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) throws Exception {
		CourseClass c1 = new CourseClass();
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter CourseCode : ");
		int a = in.nextInt();
		c1.setCourseCode(a);
		LOGGER.getInput("Enter CourseName: ");
		String b = in.next();
		c1.setCourseName(b);
		LOGGER.getInput("Enter CourseFee: ");
		int c = in.nextInt();
		c1.setCourseFee(c);
		LOGGER.getInput("Enter CourseDurationDays: ");
		int d = in.nextInt();
		c1.setCourseDurationDays(d);
		LOGGER.getInput("Enter preReq: ");
		String e =in.next();
		c1.setPreReq(e);
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.addCourses(c1);
		in.close();	
	}

}
