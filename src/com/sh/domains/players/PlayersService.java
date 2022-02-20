package com.sh.domains.players;

import static com.sh.views.InputVerification.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

import com.sh.domains.players.dtos.PlayersDto;
import com.sh.domains.players.dtos.ResultDto;

public class PlayersService {
	private static final int SYMBOL_HALF_LENGTH_OF_NAME = MAX_LENGTH_OF_NAME/2;

	public PlayersService() {}

	public Players createPlayers(PlayersDto playersDto, ResultDto resultDto, List<Integer> resultOfPlayersLadder) {
		List<String> names = playersDto.getPlayers();
		List<Result> resultOfPlayers = buildPlayersResult(resultDto, resultOfPlayersLadder);

		Players players = new Players(names, resultOfPlayers);
		return players;
	}

	/**
	 * Plyaers를 생성하기 위해 필요한 Player 별 Result를 만들기 위한 메서드입니다.
	 * - 사용자가 입력한 순서대로 Result 생성합니다.
	 * - resultOfPlayersLadder : 사다리 게임 결과에 따른 player 별 Result.idx를 데이터로 담고 있습니다.
	 * @param resultDto
	 * @param resultOfPlayersLadder
	 * @return
	 */
	private List<Result> buildPlayersResult(ResultDto resultDto, List<Integer> resultOfPlayersLadder) {
		List<Result> results = buildResults(resultDto);
		List<Result> resultOfPlayers = matchPlayersAndResult(resultOfPlayersLadder, results);
		return resultOfPlayers;
	}

	private List<Result> buildResults(ResultDto resultDto) {
		List<String> ladderGameResult = resultDto.getLadderGameResult();
		int size = ladderGameResult.size();
		List<Result> results = IntStream.range(0, size)
			.mapToObj(idx -> new Result(ladderGameResult.get(idx)))
			.collect(toList());
		return results;
	}

	private List<Result> matchPlayersAndResult(List<Integer> resultOfPlayersLadder, List<Result> results) {
		List<Result> resultOfPlayers = resultOfPlayersLadder.stream()
			.map(results::get)
			.collect(toList());
		return resultOfPlayers;
	}
}
