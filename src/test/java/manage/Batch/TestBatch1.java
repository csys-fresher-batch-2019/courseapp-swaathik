package manage.Batch;

import com.student.basics.DAOFactory;
import com.student.batch.BatchDAO;

public class TestBatch1 {

	public static void main(String[] args) throws Exception {
		 BatchDAO dao = DAOFactory.getBatchDAO();
			dao.displayBatchCodeCourseCode();
		
	}

}
