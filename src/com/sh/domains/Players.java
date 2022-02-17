package com.sh.domains;


import static com.sh.utils.InputVerification.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
	private final List<Player> players;

	public Players(List<String> names) {
		this.players = new ArrayList<>();
		addPlayers(names);
	}

	private void addPlayers(List<String> names) {
		if (Objects.isNull(names)) {
			throw new NullPointerException("players - names");
		}
		if (isMinPeoples.or(isMaxPeoples).test(names.size())) {
			throw new IllegalArgumentException(ERROR_NUMBER_OF_PEOPLE);
		}
		for (String name : names) {
			Player player = new Player(name);
			players.add(player);
		}
	}

	public int numberOf() {
		return this.players.size();
	}

	public List<String> getNames() {
		return this.players.stream()
			.map(Player::getName)
			.collect(toList());
	}
}
