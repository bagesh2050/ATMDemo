package com.atm.demo.service.helper.copy;

import java.util.List;

import com.atm.demo.model.Account;
import com.atm.demo.repository.BankAccountRepository;

public class SBI implements Bank {
	private List<Account> userAccounts;

	public SBI() {
		userAccounts = BankAccountRepository.getUserAccountByBank(BankName.SBI);
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
