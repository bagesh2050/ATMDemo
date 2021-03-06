package com.atm.demo.service.helper;

import java.util.List;

import com.atm.demo.model.Account;
import com.atm.demo.repository.BankAccountRepository;

public class HDFC implements Bank {
	private List<Account> userAccounts;

	public HDFC() {
		userAccounts = BankAccountRepository.getUserAccountByBank(BankName.HDFC);
	}

	@Override
	public boolean verifyCard(int cardNumber) {
		return BankUtils.verifyBankCard(userAccounts, cardNumber);
	}

	@Override
	public int getUserBalance(int cardNumber) {
		return BankUtils.getUserBalance(userAccounts, cardNumber);
	}

	@Override
	public synchronized boolean updateBalance(int cardNumber, int withdrawAmount) {
		return BankUtils.updateBalance(userAccounts, cardNumber, withdrawAmount);
	}
}
