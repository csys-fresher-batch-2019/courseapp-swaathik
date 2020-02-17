package manage.CourseEnroll;

import java.time.LocalDate;
import java.util.Scanner;

import com.student.CourseEnroll.CourseEnrollClass;
import com.student.CourseEnroll.CourseEnrollDAO;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;

public class TestCourseEnroll {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main (String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		CourseEnrollClass course = new CourseEnrollClass();
		LOGGER.getInput("Enter Admission Number : ");
		course.setAdmNo(in.nextInt());
		LOGGER.getInput("Enter EmailId: ");
		course.setEmailId(in.next());
		LOGGER.getInput("Enter Course Name : ");
		course.setCourseName(in.next());
		
		CourseEnrollDAO dao = DAOFactory.getCourseEnrollDAO();
		dao.addCourses(course);
		in.close();

}
}
