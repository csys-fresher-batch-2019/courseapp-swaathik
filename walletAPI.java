package com.StudentManagement2.client;

import citipe.servicelayer.UserService;

public class WalletAPI {

	private static final Long COMPANY_MOBILE_NO = 6789012340L;
	
	public static void pay(Long studentMobileNo , int pin, int amount) {
		UserService userService = new UserService();
		
		
		
		boolean status ;
		try {
			status = userService.walletTransfer(studentMobileNo, COMPANY_MOBILE_NO, pin, amount);
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
	}
}
