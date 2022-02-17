package com.sh.domains;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

	private int numberOfPeople = 5;
	private List<Boolean> filledFalseList;

	@BeforeEach
	void beforeEach() {
		filledFalseList = getFilledFalseList();
	}

	@DisplayName("true 1개 - Line 생성")
	@Test
	void acceptable_line() {
		filledFalseList.set(2, true);

		Line line = new Line(filledFalseList);

		List<Boolean> points = line.getPoints();
		assertTrue(points.contains(true));
	}

	@DisplayName("true 2개 이상 - Line 생성 불가")
	@Test
	void invalid_line() {
		List<Boolean> filledFalseList = getFilledFalseList();
		filledFalseList.set(2, true);
		filledFalseList.set(3, true);

		assertThrows(IllegalArgumentException.class, () -> {
			new Line(filledFalseList);
		});
	}

	private List<Boolean> getFilledFalseList() {
		List<Boolean> filledFalse = IntStream.range(0, numberOfPeople)
			.mapToObj(num -> false)
			.collect(toList());
		return filledFalse;
	}
}
