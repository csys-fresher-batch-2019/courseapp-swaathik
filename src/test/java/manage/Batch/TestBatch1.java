package manage.Batch;

import com.student.basics.DAOFactory;
import java.util.Scanner;
import com.student.batch.BatchDAO;

public class TestBatch1 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Course Name : ");
		String courseName = in.next();
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.displayBatchCodeCourseCode(courseName);
			in.close();
		
	}

}
