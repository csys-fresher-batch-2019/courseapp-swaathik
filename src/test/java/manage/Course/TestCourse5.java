package manage.Course;
import com.student.basics.DAOFactory;
import com.student.basics.Logger;
import com.student.course.CourseDAO;
import java.util.Scanner;
public class TestCourse5 {

	private static Logger LOGGER = Logger.getInstance();
	
	public static void main(String[] args) throws Exception  {
		
		LOGGER.getInput("Enter Course Name : ");
		Scanner in = new Scanner(System.in);
		String courseName = in.next();
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.orderBy(courseName);
		in.close();

	}

}
