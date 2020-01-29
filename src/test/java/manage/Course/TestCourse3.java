package manage.Course;
import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Course.CourseDAO;

public class TestCourse3 {

	public static void main(String[] args) throws Exception {
		//CourseImplements c4 = new CourseImplements();
		//c4.orderByCourseName();
		CourseDAO dao = DAOFactory.getCourseDAO();
		dao.orderByCourseName();
	}

}
