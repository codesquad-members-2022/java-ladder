package com.sh;

import static com.sh.utils.Input.*;
import static com.sh.utils.InputVerification.*;
import static com.sh.utils.Output.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Settings {

	public Settings() {}

	public List<String> getListOfNames() {
		try {
			println.accept(OUTPUT_NAME_LIST);
			String[] validNames = getNames();
			List<String> names = trimsName(validNames);
			return names;
		} catch (IllegalArgumentException e) {
			println.accept(e.getMessage());
			return getListOfNames();
		}
	}

	private List<String> trimsName(String[] names) {
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
		return inputValue.split(SYMBOL_NAME_SEPARATOR);
	}

	private int getHeightOfLadder(int minHeight) {
		int maxHeightOfLadder = nextInt();
		isValidHeightOfLadder(maxHeightOfLadder, minHeight);
		return maxHeightOfLadder;
	}
}
