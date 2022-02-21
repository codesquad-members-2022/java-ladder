package com.sh.domains.players.dtos;

import java.util.List;

public class ResultDto {
	private final List<String> ladderGameResult;

	public ResultDto(List<String> ladderGameResult) {
		this.ladderGameResult = ladderGameResult;
	}

	public List<String> getLadderGameResult() {
		return ladderGameResult;
	}
}
