package com.sh.domains;

import java.util.List;
import java.util.function.Predicate;

public class Line {
	private final List<Boolean> points;
	private Predicate<Boolean> isTrue = (aBoolean -> aBoolean == true);

	public Line(List<Boolean> points) {
		isValidLine(points);
		this.points = points;
	}

	public List<Boolean> getPoints() {
		return points;
	}

	private void isValidLine(List<Boolean> points) {
		long count = getCount(points);
		impossibleLine(count);
	}

	private void impossibleLine(long count) {
		if (count != 1) {
			throw new IllegalArgumentException("Line - count");
		}
	}

	private long getCount(List<Boolean> points) {
		return points.stream()
			.parallel()
			.filter(isTrue::test)
			.limit(2)
			.count();
	}
}
