package com.student.batch;

import java.util.List;

public interface BatchDAO {
	//insert into Batches(batch_code,course_code,starting_date,end_date) 
	void addBatches(BatchClass batch);
	

	//select batch_code,course_code,course_name from batches;
	List<BatchClass>displayBatchCodeCourseCode() ;
	
	
	//delete from batches where batch_code = ?
	void deleteBatches (int batchCode);
	
	//update batches set batch_code=555 where course_code=?
	void updateBatches(int receiptNo) ;
	

}
