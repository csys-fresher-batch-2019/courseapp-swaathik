package manage.Batch;

import com.student.basics.DAOFactory;
import com.student.batch.BatchDAO;

public class TestBatch1 {

	public static void main(String[] args) throws Exception {
		//BatchImplements obj = new BatchImplements();
		//obj.displayBatchCodeCourseCode();
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.displayBatchCodeCourseCode();
		
	}

}
