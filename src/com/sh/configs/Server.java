package com.sh.configs;

import static com.sh.views.Input.*;
import static com.sh.views.Output.*;

import java.util.List;

import com.sh.domains.ladders.Ladder;
import com.sh.domains.ladders.LadderService;
import com.sh.domains.ladders.dtos.LadderDto;
import com.sh.domains.players.Players;
import com.sh.domains.players.PlayersService;
import com.sh.domains.players.dtos.PlayersDto;
import com.sh.domains.players.dtos.ResultDto;

public class Server {
	private static final Server SERVER = new Server();
	public static final String  OUTPUT_RESULT_OF_LADDER = "사다리 결과";
	public static final String OUTPUT_REQUEST_PLAYER_RESULT = "결과를 보고 싶은 사람은?";
	public static final String COMMAND_END = "춘식이";
	public static final String OUTPUT_REQUEST_ALL_PLAYER_RESULT = "all";
	public static final String OUTPUT_MESSAGE_OF_END = "게임을 종료합니다.";

	private LadderService ladderService;
	private PlayersService playersService;
	private LadderDto ladderDto;
	private PlayersDto playersDto;
	private ResultDto resultDto;

	private Server() {
	}

	public static Server getInstance() {
		return SERVER;
	}

	public void run() {
		try {
			ready();
			toLadder();
			Ladder ladder = ladderService.createLadder(ladderDto);
			String ladderDrawing = ladderService.resultOfLadder(ladder);
			Players players = getPlayers(ladder);

			printResultOfLadder(players, ladderDrawing);
			askLadderResultOfPlayer(players);
		} catch (IllegalArgumentException | NullPointerException exception) {
			println.accept(exception.getMessage());
			run();
		}
	}

	private void printResultOfLadder(Players players, String ladderDrawing) {
		println.accept(OUTPUT_RESULT_OF_LADDER);
		StringBuilder sb = new StringBuilder();
		String playersNames = playersService.getPlayersNames(players);
		String resultInput = playersService.getLadderResult(resultDto);
		sb.append(playersNames)
			.append(ladderDrawing)
			.append(resultInput);
		println.accept(sb.toString());
	}

	private void askLadderResultOfPlayer(Players players) {
		try {
			println.accept(OUTPUT_REQUEST_PLAYER_RESULT);
			String askedName = nextLine();
			requestPlayer(players, askedName);
			println.accept(OUTPUT_MESSAGE_OF_END);
		} catch (IllegalArgumentException exception) {
			println.accept(exception.getMessage());
			askLadderResultOfPlayer(players);
		}
	}

	private void requestPlayer(Players players, String askedName) {
		while (!askedName.equals(COMMAND_END)) {
			String response = responseOf(players, askedName);
			println.accept(response);

			println.accept(OUTPUT_REQUEST_PLAYER_RESULT);
			askedName = nextLine();
		}
	}

	private String responseOf(Players players, String askedName) {
		if (askedName.equals(OUTPUT_REQUEST_ALL_PLAYER_RESULT)) {
			return playersService.getResultAllPlayers(players);
		}
		return playersService.getResultOfPlayer(players, askedName);
	}


	private Players getPlayers(Ladder ladder) {
		List<Integer> resultOfPlayers = ladderService.resultOfPlayers(ladder);
		Players players = playersService.createPlayers(playersDto, resultDto, resultOfPlayers);
		return players;
	}

	private void toLadder() {
		ladderService = new LadderService();
		playersService = new PlayersService();
	}

	private void ready() {
		Settings settings = new Settings();
		List<String> names = settings.getListOfNames();
		int numberOfPeoples = names.size();
		List<String> ladderGameResult = settings.getListOfLadderGameResult(numberOfPeoples);
		int height = settings.getHeight(numberOfPeoples);

		this.ladderDto = new LadderDto(names.size(), height);
		this.playersDto = new PlayersDto(names);
		this.resultDto = new ResultDto(ladderGameResult);
	}
}
