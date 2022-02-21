package com.sh.configs;

import static com.sh.views.Input.*;
import static com.sh.views.InputVerification.*;
import static com.sh.views.Output.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Settings {

	public Settings() {
	}

	public List<String> getListOfNames() {
		try {
			println.accept(OUTPUT_NAME_LIST);
			String[] validNames = getNames();
			List<String> names = trimsText(validNames);
			return names;
		} catch (IllegalArgumentException e) {
			println.accept(e.getMessage());
			return getListOfNames();
		}
	}

	public List<String> getListOfLadderGameResult(int numberOfPeoples) {
		try {
			println.accept(OUTPUT_RESULT_OF_GAME);
			String[] validResultInfo = getResultOfLadder(numberOfPeoples);
			List<String> results = trimsText(validResultInfo);
			return results;
		} catch (IllegalArgumentException e) {
			println.accept(e.getMessage());
			return getListOfLadderGameResult(numberOfPeoples);
		}
	}

	private List<String> trimsText(String[] names) {
		return Arrays.stream(names)
			.parallel()
			.map(String::trim)
			.collect(Collectors.toUnmodifiableList());
	}

	public int getHeight(int numberOfPeople) {
		try {
			int minHeight = numberOfPeople - 1;
			println.accept(OUTPUT_MAX_HEIGHT_OF_LADDER);
			int height = getHeightOfLadder(minHeight);
			return height;
		} catch (IllegalArgumentException e) {
			println.accept(e.getMessage());
			return getHeight(numberOfPeople);
		}
	}

	private String[] getNames() {
		String inputValue = nextLine();
		isValidNames(inputValue);
		return inputValue.split(SYMBOL_SEPARATOR);
	}

	private String[] getResultOfLadder(int numberOfPeoples) {
		String inputValue = nextLine();
		isValidResultInfo(inputValue, numberOfPeoples);
		return inputValue.split(SYMBOL_SEPARATOR);
	}

	private int getHeightOfLadder(int minHeight) {
		int maxHeightOfLadder = nextInt();
		isValidHeightOfLadder(maxHeightOfLadder, minHeight);
		return maxHeightOfLadder;
	}
}
