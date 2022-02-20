package com.sh.domains.players;


import static com.sh.views.InputVerification.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
	public static final String ERROR_NOT_INCLUDE_PLAYERS = "플레이어 이름을 확인 후 재입력 해주세요.";
	private final List<Player> players;

	public Players(List<String> names, List<Result> results) {
		this.players = new ArrayList<>();
		addPlayers(names, results);
	}

	public void isName(String name) {
		boolean isContains = getNames().contains(name);
		if (!isContains) {
			throw new IllegalArgumentException(ERROR_NOT_INCLUDE_PLAYERS);
		}
	}

	private void addPlayers(List<String> names, List<Result> results) {
		invalidNamesAndResults(names, results);
		int size = names.size();
		for (int i = 0; i < size; i++) {
			String name = names.get(i);
			Result result = results.get(i);
			Player player = new Player(name, result);
			players.add(player);
		}
	}

	private void invalidNamesAndResults(List<String> names, List<Result> results) {
		List<String> resultString = toTextFrom(results);
		isNull(names);
		isNull(resultString);
		isRangeOf(names);
		isRangeOf(resultString);
	}

	private List<String> toTextFrom(List<Result> results) {
		return results.stream()
			.parallel()
			.map(Result::content)
			.collect(toList());
	}

	private void isRangeOf(List<String> names) {
		if (isMinPeoples.or(isMaxPeoples).test(names.size())) {
			throw new IllegalArgumentException(ERROR_NUMBER_OF_PEOPLE);
		}
	}

	private void isNull(List<String> names) {
		if (Objects.isNull(names)) {
			throw new NullPointerException("players - names");
		}
	}

	public List<String> getNames() {
		return this.players.stream()
			.map(Player::getName)
			.collect(toList());
	}

	public List<String> getAllResults() {
		return this.players.stream()
			.map(Player::getResult)
			.collect(toList());
	}

	public String getPersonalResult(String name) {
		Player findPlayer = players.stream()
			.parallel()
			.filter(player -> player.isSame(name))
			.findAny()
			.orElseThrow(() -> {
				throw new IllegalArgumentException("해당 플레이어는 없습니다.");
			});
		return findPlayer.getResult();
	}
}
