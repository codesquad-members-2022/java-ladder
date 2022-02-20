package com.sh.domains.players;

import static com.sh.views.InputVerification.*;

import java.util.Objects;

public class Player {
	public static final String ERROR_OF_NPE_PLAYER_RESULT = "NPE : Player - result";
	private final String name;
	private final Result result;

	public Player(String name, Result result) {
		if (isStringBlank.or(isValidLength).test(name)) {
			throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);
		}
		if (Objects.isNull(result)) {
			throw new IllegalArgumentException(ERROR_OF_NPE_PLAYER_RESULT);
		}
		this.name = name;
		this.result = result;
	}

	public String getName() {
		return name;
	}
}
