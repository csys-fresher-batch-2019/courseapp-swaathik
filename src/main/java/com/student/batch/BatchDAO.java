package com.student.batch;

import java.sql.SQLException;
import java.util.List;

public interface BatchDAO {
	
	
	void addBatches(BatchClass batch);
	

	List<BatchClass>displayBatchCodeCourseCode(String courseName) throws SQLException ;
	
	
	void deleteBatches (int batchCode);
	
	void updateBatches(int receiptNo) ;
	

}
