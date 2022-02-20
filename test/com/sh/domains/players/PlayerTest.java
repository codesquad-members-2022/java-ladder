package com.sh.domains.players;

import static com.sh.views.InputVerification.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
	@DisplayName("이름 - 예외")
	@ParameterizedTest
	@ValueSource(strings = {"abcdef", " "})
	void invalid_name_of_player_exception(String name) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Player(name, new Result("1등"));
		});
	}

	@DisplayName("정상 이름 - 플레이어 생성")
	@ParameterizedTest
	@ValueSource(strings = {"abcde", "honux", "JK"})
	void acceptable_name_of_player_exception(String name) {
		Player player = new Player(name, new Result("1등"));

		String actual = player.getName();

		assertTrue(actual.length() <= MAX_LENGTH_OF_NAME);
	}
}
