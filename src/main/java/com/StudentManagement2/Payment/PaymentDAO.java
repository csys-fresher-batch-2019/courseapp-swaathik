package com.StudentManagement2.Payment;

import java.util.List;

public interface PaymentDAO {

	void addPayments(PaymentClass payment) throws Exception;
	
	void updatePayments(int receiptNo) throws Exception;
	
	List<PaymentClass> displayAmountPaid () throws Exception;
	
	void deletePayments(int receiptNo) throws Exception;
	
}
