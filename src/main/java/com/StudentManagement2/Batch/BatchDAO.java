package com.StudentManagement2.Batch;

import java.util.List;

public interface BatchDAO {
	//insert into Batches(batch_code,course_code,starting_date,end_date) 
	void addBatches(BatchClass batch) throws Exception;
	

	//select starting_date,end_date from batches order by batch_code;
	List<BatchClass>displayBatchCodeCourseCode() throws Exception;
	
	
	//delete from batches where batch_code = ?
	void deleteBatches (int batchCode) throws Exception;
	
	//update batches set batch_code=555 where course_code=?
	void updateBatches(int receiptNo) throws Exception;
	

}