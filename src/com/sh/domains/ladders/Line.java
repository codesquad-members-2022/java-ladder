package com.sh.domains.ladders;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Line {
	private final List<Boolean> points;

	public Line(List<Boolean> points) {
		isValidLine(points);
		this.points = points;
	}

	public List<Boolean> getPoints() {
		return points;
	}

	private void isValidLine(List<Boolean> points) {
		int size = points.size()-1;
		for (int i = 0; i < size; i+=2) {
			isContinuousLadder(points.get(i), points.get(i + 1));
		}
	}

	private void isContinuousLadder(Boolean a, Boolean b) {
		BothTrue compared = new BothTrue() {
			@Override
			public boolean isAnd(boolean a, boolean b) {
				return (a && b);
			}
		};
		if (compared.isAnd(a,b)) {
			throw new IllegalArgumentException("Line - count");
		}
	}
}
