package com.sh.domains;


import java.util.ArrayList;
import java.util.List;

public class Players {
	private final List<Player> players;

	public Players(List<String> names) {
		this.players = new ArrayList<>();
		addPlayers(names);
	}

	private void addPlayers(List<String> names) {
		for (String name : names) {
			Player player = new Player(name);
			players.add(player);
		}
	}

	public int numberOf() {
		return this.players.size();
	}
}
