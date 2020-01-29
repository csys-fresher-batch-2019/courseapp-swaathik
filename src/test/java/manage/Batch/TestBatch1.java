package manage.Batch;

import com.StudentManagement2.Basics.DAOFactory;
import com.StudentManagement2.Batch.BatchDAO;

public class TestBatch1 {

	public static void main(String[] args) throws Exception {
		//BatchImplements obj = new BatchImplements();
		//obj.displayBatchCodeCourseCode();
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.displayBatchCodeCourseCode();
		
	}

}
