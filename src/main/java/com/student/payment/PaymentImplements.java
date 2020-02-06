package com.student.payment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.basics.ConnectionUtil;
import com.student.basics.Logger;
public class PaymentImplements implements PaymentDAO {
	private static Logger LOGGER = Logger.getInstance();
	public void addPayments(PaymentClass payment) throws Exception {
		String sql = "insert into payments(receipt_no,adm_no,amount_paid,pay_date,re_marks) values(receipt_no_sq.nextval,?,?,?,?)";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,payment.getAdmNo());
			pst.setInt(2, payment.getAmountPaid());
			pst.setDate(3, Date.valueOf(payment.getPayDate()));
			pst.setString(4, payment.getReMarks());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}	
	}

	public void updatePayments(int receiptNo) throws Exception {
		String sql = "update payments set re_marks='Cheque' where receipt_no=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,receiptNo);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows Updated : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}		
	}

	public List<PaymentClass> displayAmountPaid() throws Exception {
		List<PaymentClass> p = new ArrayList<>();
		String sql = "select receipt_no,amount_paid from payments";
		try(Connection connection = ConnectionUtil.getConnection();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				int receiptNo = rs.getInt("receipt_No");
				int amountPaid = rs.getInt("amount_Paid");
				PaymentClass payment = new PaymentClass();
				payment.setReceiptNo(receiptNo);
				payment.setAmountPaid(amountPaid);
				LOGGER.debug(receiptNo+" "+amountPaid);
				p.add(payment);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		return p;
	}

	public void deletePayments(int receiptNo) throws Exception {
		String sql = "update payments set receipt_active = 0 where receipt_no=?";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1,receiptNo);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted : "+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	}	
	}