package com.atm.demo.service.helper.copy;

public class BankInterface {
	public static boolean isCardValid(int cardNumber) {
		return BankFactory.getBank(cardNumber).verifyCard(cardNumber);
	}

	public static int getUserBalance(int cardNumber) {
		return BankFactory.getBank(cardNumber).getUserBalance(cardNumber);
	}

	public static boolean updateUserBalance(int cardNumber, int withdrawAmount) {
		return BankFactory.getBank(cardNumber).updateBalance(cardNumber, withdrawAmount);
	}
}
