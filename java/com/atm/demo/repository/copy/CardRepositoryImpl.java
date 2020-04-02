package com.atm.demo.repository.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.atm.demo.model.Card;
import com.atm.demo.service.helper.BankName;

public class CardRepositoryImpl implements CardRepository {
	private static Map<Integer, Card> cardsMap = new HashMap<>(300);

	private void loadCardsMap() {
		// Adding ICICI Cards
		for (int i = 1; i < 50; i++) {
			int cardNumber = 1000 + i;
			Card card = new Card();
			card.setUserId(100 + i);
			card.setActive(true);
			card.setIssuingBank(BankName.SBI);
			card.setCardNumber(cardNumber);
			cardsMap.put(cardNumber, card);
		}

		// Adding HDFC Cards
		for (int i = 50; i < 100; i++) {
			int cardNumber = 2000 + i;
			Card card = new Card();
			card.setUserId(100 + i);
			card.setActive(true);
			card.setIssuingBank(BankName.ICICI);
			card.setCardNumber(cardNumber);
			cardsMap.put(cardNumber, card);
		}

		// Adding SBI Cards
		for (int i = 100; i < 150; i++) {
			int cardNumber = 3000 + i;
			Card card = new Card();
			card.setUserId(100 + i);
			card.setActive(true);
			card.setIssuingBank(BankName.HDFC);
			card.setCardNumber(cardNumber);
			cardsMap.put(cardNumber, card);
		}
	}

	public synchronized List<Card> getUserCard(int userId) {
		if (cardsMap == null) {
			loadCardsMap();
		}

		List<Card> tempCardList = new ArrayList<>();

		for (Entry<Integer, Card> entry : cardsMap.entrySet()) {
			Card card = entry.getValue();
			int cardUserId = card.getUserId();

			if (cardUserId == userId) {
				tempCardList.add(card);
				break; // Currently working on one card per User
			}
		}

		return tempCardList;
	}

	@Override
	public BankName getUserBank(int cardNumber) {
		if (cardsMap != null)
			return cardsMap.get(cardNumber).getIssuingBank();

		return null;
	}
}
