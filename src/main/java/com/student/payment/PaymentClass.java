package com.student.payment;

import java.time.LocalDate;

public class PaymentClass {
	private int receiptNo;
	private int admNo;
	private int amountPaid;
	private LocalDate payDate;
	private String reMarks;
	public int getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}
	public int getAdmNo() {
		return admNo;
	}
	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public LocalDate getPayDate() {
		return payDate;
	}
	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}
	public String getReMarks() {
		return reMarks;
	}
	public void setReMarks(String reMarks) {
		this.reMarks = reMarks;
	}
	
	@Override
	public String toString() {
		return "PaymentClass [receiptNo=" + receiptNo + ", admNo=" + admNo + ", amountPaid=" + amountPaid + ", payDate="
				+ payDate + ", reMarks=" + reMarks + "]";
	}

}
