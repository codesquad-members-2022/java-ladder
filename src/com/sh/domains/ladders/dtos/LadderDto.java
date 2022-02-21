package com.sh.domains.ladders.dtos;

public class LadderDto {
	private final int numberOfPeoples;
	private final int height;

	public LadderDto(int numberOfPeoples, int height) {
		this.numberOfPeoples = numberOfPeoples;
		this.height = height;
	}

	public int getNumberOfPeoples() {
		return numberOfPeoples;
	}

	public int getHeight() {
		return height;
	}
}
