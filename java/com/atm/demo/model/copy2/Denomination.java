package com.atm.demo.model.copy2;

import java.util.HashSet;
import java.util.Set;

public enum Denomination {

	FIVE_HUNDRED(500),
	TWO_HUNDRED(200),
	ONE_HUNDRED(100),
	TWENTY(20),
	TEN(10);

	private int id;

	Denomination(int id) {
		this.id = id;
	}

	public int getDemonination() {
		return id;
	}

	public static Set<Integer> getAvailableDenominations() {
		Set<Integer> denoSet = new HashSet<>();

		for (Denomination deno : Denomination.values()) {
			denoSet.add(deno.getDemonination());
		}

		return denoSet;
	}
}
