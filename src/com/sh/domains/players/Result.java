package com.sh.domains.players;

import static com.sh.views.InputVerification.*;

public class Result {
	private final String result;

	public Result(String result) {
		if (isStringBlank.or(isValidLength).test(result)) {
			throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);
		}
		this.result = result;
	}

	public String content() {
		return result;
	}
}
