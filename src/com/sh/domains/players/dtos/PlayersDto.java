package com.sh.domains.players.dtos;

import java.util.List;

public class PlayersDto {
	private final List<String> players;

	public PlayersDto(List<String> players) {
		this.players = players;
	}

	public List<String> getPlayers() {
		return players;
	}
}
