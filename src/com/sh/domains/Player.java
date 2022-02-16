package com.sh.domains;

import static com.sh.utils.InputVerification.*;

public class Player {
	private final String name;

	public Player(String name) {
		if (isStringBlank.or(isValidName).test(name)) {
			throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
