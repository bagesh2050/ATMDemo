package com.atm.demo.service.helper;

import com.atm.demo.repository.CardRepository;
import com.atm.demo.repository.CardRepositoryImpl;

public class BankFactory {
	private static CardRepository cardRepo = new CardRepositoryImpl();

	public static Bank getBank(int cardNumber) {
		BankName bankName = cardRepo.getUserBank(cardNumber);

		switch (bankName) {
		case SBI:
			return new SBI();

		case ICICI:
			return new ICICI();

		case HDFC:
			return new HDFC();

		default:
			return null;
		}
	}
}
