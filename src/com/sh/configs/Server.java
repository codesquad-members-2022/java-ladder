package com.sh.configs;

import static com.sh.views.Output.*;

import java.util.List;

import com.sh.domains.Ladder;
import com.sh.domains.LadderService;
import com.sh.domains.Players;

public class Server {
	private static final Server SERVER = new Server();

	private Server() {
	}

	public static Server getInstance() {
		return SERVER;
	}

	private List<String> names;
	private int height;
	private Players players;
	private Ladder ladder;
	private LadderService ladderService;

	public void run() {
		try {
			ready();
			toLadder();
			String result = ladderService.resultOfPlay();
			println.accept(result);
		} catch (IllegalArgumentException | NullPointerException exception) {
			println.accept(exception.getMessage());
			run();
		}
	}

	private void toLadder() {
		players = new Players(names);
		ladder = new Ladder(players.numberOf(), height);
		ladderService = new LadderService(players, ladder);
	}

	private void ready() {
		Settings settings = new Settings();
		names = settings.getListOfNames();
		height = settings.getHeight(names.size());
	}
}
