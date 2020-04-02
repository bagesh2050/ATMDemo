package com.atm.demo.service.copy2;

public interface Machine {
	boolean verifyCard(int cardNumber);

	int getUserBalance(int cardNumber);

	boolean updateAccountAfterWithdrawl(int cardNumber, int withdrawAmount);

	String withdrawMoney(int cardNumber, int requestedMoney);
}
