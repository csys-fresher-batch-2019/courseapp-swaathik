package manage.Course;
import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Basics.Logger;
import com.StudentManagement2.Course.CourseDAO;
import com.StudentManagement2.client.WalletAPI;

import java.util.Scanner;
public class TestCourse4 {
private static Logger LOGGER = Logger.getInstance();
public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter CourseCode : ");
		int courseCode = in.nextInt();
		CourseDAO dao  = DAOFactory.getCourseDAO();
		int fees = dao.getCourseFees(courseCode);
		System.out.println("Enter mobile no: ");
		Long mobileNo = in.nextLong();
		System.out.println("Enter pin");
		int pinNumber = in.nextInt();
		WalletAPI.pay(mobileNo,  pinNumber, fees);
		in.close();

	}

}
