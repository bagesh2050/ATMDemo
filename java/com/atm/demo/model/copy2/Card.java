package com.atm.demo.model.copy2;

import com.atm.demo.service.helper.BankName;

public class Card {
	private int userId;
	private int cardNumber;
	private BankName issuingBank;
	private boolean isActive;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public BankName getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(BankName issuingBank) {
		this.issuingBank = issuingBank;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
