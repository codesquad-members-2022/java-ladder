package com.sh.domains;

import static com.sh.domains.LadderServiceTest.*;
import static com.sh.utils.InputVerification.*;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;


import org.junit.jupiter.api.Test;

class PlayersTest {
	private List<String> invalidShortNames = List.of("pobi", "  ");
	private List<String> invalidLongNames = getInvalidLongNames();
	private int invalidLength = MAX_NUMBER_OF_PEOPLE + 1;

	@Test
	void invalid_players_size_when_short() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Players(invalidLongNames);
		});
	}

	@Test
	void invalid_players_size_when_large() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Players(invalidLongNames);
		});
	}

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
