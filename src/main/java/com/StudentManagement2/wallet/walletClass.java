package com.StudentManagement2.wallet;

public class walletClass {
	private long mobileNumber ;
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getOriginator() {
		return originator;
	}
	public void setOriginator(long originator) {
		this.originator = originator;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	private long originator;
	private int pinNumber ;
	private float amount;

}
