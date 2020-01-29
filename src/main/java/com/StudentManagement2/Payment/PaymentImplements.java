package com.StudentManagement2.Payment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.StudentManagement2.Basics.Logger;
public class PaymentImplements implements PaymentDAO {
	private static Logger LOGGER = Logger.getInstance();
	public void addPayments(PaymentClass payment) throws Exception {
		String sql = "insert into payments(receipt_no,adm_no,amount_paid,pay_date,re_marks) values(?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		//Step 2: Prepare the Query
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, payment.getReceiptNo());
		pst.setInt(2,payment.getAdmNo());
		pst.setInt(3, payment.getAmountPaid());
		pst.setDate(4, Date.valueOf(payment.getPayDate()));
		pst.setString(5, payment.getReMarks());
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted : "+rows);	
	}

	public void updatePayments(int receiptNo) throws Exception {
		String sql = "update payments set re_marks='Cheque' where receipt_no=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1,receiptNo);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows Updated : "+rows);		
	}

	public List<PaymentClass> displayAmountPaid() throws Exception {
		List<PaymentClass> p = new ArrayList<PaymentClass>();
		String sql = "select receipt_no,amount_paid from payments";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int receiptNo = rs.getInt("receipt_No");
			int amountPaid = rs.getInt("amount_Paid");
			
			PaymentClass payment = new PaymentClass();
			payment.setReceiptNo(receiptNo);
			payment.setAmountPaid(amountPaid);
			LOGGER.debug(receiptNo+" "+amountPaid);
			p.add(payment);
		}
		return p;
	}

	public void deletePayments(int receiptNo) throws Exception {
		String sql = "delete from payments where receipt_no=?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1,receiptNo);
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted : "+rows);
	}	
	}
	


