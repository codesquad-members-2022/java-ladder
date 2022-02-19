package com.sh.domains;

import static com.sh.domains.LadderServiceTest.*;
import static com.sh.views.InputVerification.*;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
	private List<String> invalidShortNames = List.of("pobi", "  ");
	private List<String> invalidLongNames = getInvalidLongNames();
	private int invalidLength = MAX_NUMBER_OF_PEOPLE + 1;

	@DisplayName("적은 인원 - 예외")
	@Test
	void invalid_players_size_when_short() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Players(invalidShortNames);
		});
	}

	@DisplayName("한도 넘는 인원 - 예외")
	@Test
	void invalid_players_size_when_large() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Players(invalidLongNames);
		});
	}

	@DisplayName("플레이어스 생성")
	@Test
	void create_players() {
		List<String> names = getNames();
		Players players = new Players(names);

		List<String> actual = players.getNames();

		assertTrue(actual.size() > MIN_NUMBER_OF_PEOPLE);
		assertTrue(actual.size() < invalidLength);
	}

	private List<String> getInvalidLongNames() {
		return IntStream.rangeClosed(0, invalidLength)
			.mapToObj(String::valueOf)
			.collect(toList());
	}
}
