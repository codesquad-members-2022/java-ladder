package com.sh.domains;

import static com.sh.utils.InputVerification.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
	@ParameterizedTest
	@ValueSource(strings = {"abcdef", " "})
	void invalid_name_of_player_exception(String name) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Player(name);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcde", "honux", "JK"})
	void acceptable_name_of_player_exception(String name) {
		Player player = new Player(name);

		String actual = player.getName();

		assertTrue(actual.length() <= MAX_LENGTH_OF_NAME);
	}
}
