package manage.Course;
import java.util.Scanner;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Course.CourseClass;
import com.StudentManagement2.Course.CourseDAO;

public class TestCourse {
	private static Logger LOGGER = Logger.getInstance();

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
		//call dao
		//CourseImplements daoimpl1 = new CourseImplements();
		//daoimpl1.addCourses(c1);
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.addCourses(c1);
		in.close();
		//333	HTML	5000	50	
	}

}
