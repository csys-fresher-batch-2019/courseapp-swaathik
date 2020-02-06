package com.student.batch;

import java.util.List;

public interface BatchDAO {
	 
	void addBatches(BatchClass batch);
	

	List<BatchClass>displayBatchCodeCourseCode() ;
	
	
	void deleteBatches (int batchCode);
	
	void updateBatches(int receiptNo) ;
	

}
