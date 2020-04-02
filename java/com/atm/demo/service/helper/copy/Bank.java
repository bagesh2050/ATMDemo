package com.atm.demo.service.helper.copy;

public interface Bank {
	boolean verifyCard(int cardNumber);

	int getUserBalance(int cardNumber);

	boolean updateBalance(int cardNumber, int withdrawAmount);
}
