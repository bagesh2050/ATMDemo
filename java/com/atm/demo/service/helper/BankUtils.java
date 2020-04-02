package com.atm.demo.service.helper;

import java.util.List;
import java.util.Optional;

import com.atm.demo.model.Account;

public class BankUtils {
	public static boolean verifyBankCard(List<Account> userAccounts, int cardNumber) {
		Optional<Account> accountOpt = userAccounts.stream()
				.filter(account -> (account.isActive() && account.getCard().getCardNumber() == cardNumber)).findAny();

		if (accountOpt.isPresent()) {
			return accountOpt.get().getCard().isActive();
		}
		return false;
	}

	public static int getUserBalance(List<Account> userAccounts, int cardNumber) {
		Optional<Account> accountOpt = userAccounts.stream()
				.filter(account -> (account.isActive() && account.getCard().getCardNumber() == cardNumber)).findAny();

		if (accountOpt.isPresent()) {
			return accountOpt.get().getBalance();
		}
		return 0;
	}

	public static boolean updateBalance(List<Account> userAccounts, int cardNumber, int withdrawAmount) {
		Optional<Account> accountOpt = userAccounts.stream()
				.filter(account -> account.getCard().getCardNumber() == cardNumber).findAny();

		if (accountOpt.isPresent()) {
			Account acct = accountOpt.get();
			int balance = acct.getBalance();
			acct.setBalance(balance - withdrawAmount);
			return true;
		}
		return false;
	}
}
