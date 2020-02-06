package com.student.payment;

import java.util.List;

public interface PaymentDAO {

	void addPayments(PaymentClass payment) ;
	
	void updatePayments(int receiptNo) ;
	
	List<PaymentClass> displayAmountPaid ();
	
	void deletePayments(int receiptNo);
	
}
