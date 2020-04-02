package com.atm.demo.repository.copy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.atm.demo.model.Account;
import com.atm.demo.model.Card;
import com.atm.demo.service.helper.BankName;

public class BankAccountRepository {

	private static Map<BankName, List<Account>> bankAccountsMap;

	public static synchronized List<Account> getUserAccountByBank(BankName bank) {
		if (bankAccountsMap == null || bankAccountsMap.get(bank) == null) {
			getUserAccount(bank);
		}

		return bankAccountsMap.get(bank);
	}

	private static void getUserAccount(BankName bank) {
		bankAccountsMap = new EnumMap<>(BankName.class);
		CardRepository cardRepo = new CardRepositoryImpl();

		switch (bank) {
		case SBI:
			List<Account> sbiBankAccounts = new ArrayList<>();

			for (int i = 1; i < 50; i++) {
				int userId = 100 + i;

				Account sbiAccount = new Account();
				sbiAccount.setUserId(userId);
				sbiAccount.setUserName(BankName.SBI.name() + " " + i);
				sbiAccount.setAccountNumber(1000 + i);
				sbiAccount.setActive(true);
				sbiAccount.setBalance(1000);

				List<Card> sbiCard = cardRepo.getUserCard(userId);
				if (!sbiCard.isEmpty())
					sbiAccount.setCard(sbiCard.get(0));

				sbiBankAccounts.add(sbiAccount);
			}

			bankAccountsMap.put(bank, sbiBankAccounts);

			break;

		case ICICI:
			List<Account> iciciBankAccounts = new ArrayList<>();

			for (int i = 50; i < 100; i++) {
				int userId = 100 + i;

				Account iciciAccount = new Account();
				iciciAccount.setUserId(userId);
				iciciAccount.setUserName(BankName.ICICI.name() + " " + i);
				iciciAccount.setAccountNumber(2000 + i);
				iciciAccount.setActive(true);
				iciciAccount.setBalance(2000);

				List<Card> iciciCard = cardRepo.getUserCard(userId);

				if (!iciciCard.isEmpty())
					iciciAccount.setCard(iciciCard.get(0));

				iciciBankAccounts.add(iciciAccount);
			}

			bankAccountsMap.put(bank, iciciBankAccounts);

			break;

		case HDFC:
			List<Account> hdfcBankAccounts = new ArrayList<>();

			for (int i = 100; i < 150; i++) {
				int userId = 100 + i;

				Account hdfcAccount = new Account();
				hdfcAccount.setUserId(userId);
				hdfcAccount.setUserName(BankName.HDFC.name() + " " + i);
				hdfcAccount.setAccountNumber(3000 + i);
				hdfcAccount.setActive(true);
				hdfcAccount.setBalance(3000);

				List<Card> hdfcCard = cardRepo.getUserCard(userId);

				if (!hdfcCard.isEmpty())
					hdfcAccount.setCard(hdfcCard.get(0));

				hdfcBankAccounts.add(hdfcAccount);
			}

			bankAccountsMap.put(bank, hdfcBankAccounts);

			break;

		default:
			break;
		}
	}
}
