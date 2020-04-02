package com.atm.demo.service.copy;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.atm.demo.model.Denomination;
import com.atm.demo.service.helper.BankInterface;

public class MachineImpl implements Machine {
	private static AtomicInteger amountInMachine = new AtomicInteger(2000);
	private static Map<Denomination, Integer> denominationMap = new EnumMap<>(Denomination.class);

	static {
		denominationMap.put(Denomination.FIVE_HUNDRED, 100);
		denominationMap.put(Denomination.TWO_HUNDRED, 400);
		denominationMap.put(Denomination.ONE_HUNDRED, 1000);
		denominationMap.put(Denomination.TWENTY, 2000);
		denominationMap.put(Denomination.TEN, 5000);

		updateAvailableCashInMachine();
	}

	private static void updateAvailableCashInMachine() {
		for (Entry<Denomination, Integer> entry : denominationMap.entrySet()) {
			Denomination key = entry.getKey();
			Integer value = entry.getValue();

			switch (key) {
			case FIVE_HUNDRED:
				amountInMachine.getAndAdd(value * Denomination.FIVE_HUNDRED.getDemonination());
				break;

			case TWO_HUNDRED:
				amountInMachine.getAndAdd(value * Denomination.TWO_HUNDRED.getDemonination());
				break;

			case ONE_HUNDRED:
				amountInMachine.getAndAdd(value * Denomination.ONE_HUNDRED.getDemonination());
				break;
			case TWENTY:
				amountInMachine.getAndAdd(value * Denomination.TWENTY.getDemonination());
				break;
			case TEN:
				amountInMachine.getAndAdd(value * Denomination.TEN.getDemonination());
				break;

			default:
				break;
			}
		}
	}

	@Override
	public boolean verifyCard(int cardNumber) {
		return BankInterface.isCardValid(cardNumber);
	}

	@Override
	public int getUserBalance(int cardNumber) {
		return BankInterface.getUserBalance(cardNumber);
	}

	@Override
	public boolean updateAccountAfterWithdrawl(int cardNumber, int withdrawAmount) {
		return BankInterface.updateUserBalance(cardNumber, withdrawAmount);
	}

	@Override
	public String withdrawMoney(int cardNumber, int requestedMoney) {
		StringBuilder msg = new StringBuilder("Transaction Failed -");

		if (verifyCard(cardNumber)) {
			if (amountInMachine.get() >= requestedMoney) {
				if (getUserBalance(cardNumber) >= requestedMoney) {
					if (requestedMoney % 10 == 0) {
						int sumMoney = 0;
						Set<Integer> availableDeno = Denomination.getAvailableDenominations();

						for (int i = availableDeno.size() - 1; i >= 0; i--) {
							int numberOfNotes = Math.round((requestedMoney - sumMoney) / availableDeno.get);

							if (numberOfNotes > 0) {

							}
						}
					} else {
						msg.append("Enter amount multiple of 10");
					}
				} else {
					msg.append("User Balance is low than requested amount");
				}
			} else {
				msg.append("Unable to dispense Cash. Cash Not Available");
			}
		} else {
			msg.append("Card is Invalid");
		}

		return msg.toString();
	}
}
