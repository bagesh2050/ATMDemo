package com.atm.demo.repository;

import java.util.List;

import com.atm.demo.model.Card;
import com.atm.demo.service.helper.BankName;

public interface CardRepository {
	List<Card> getUserCard(int userId);

	BankName getUserBank(int cardNumber);
}
