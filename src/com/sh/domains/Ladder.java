package com.sh.domains;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.sh.utils.Randomz;

public class Ladder {
	private final int rangeOfx;
	private final int rangeOfy;
	private Randomz random;
	private int limitNumberOfLadder;
	private List<Line> graphs = new ArrayList<>();
	private Predicate<Boolean> isDiscontinuous = (bool) -> (bool ? false : true);

	public Ladder(int rangeOfx, int rangeOfy) {
		if (Objects.isNull(rangeOfx) || Objects.isNull(rangeOfy)) {
			throw new NullPointerException("NPE - constructor of Ladder");
		}
		this.rangeOfx = rangeOfx - 1;
		this.rangeOfy = rangeOfy;
		this.graphs = new ArrayList<>();
		this.random = Randomz.getInstance();
		this.limitNumberOfLadder = halfLengthInWidth();
	}

	private int halfLengthInWidth() {
		return this.rangeOfx / 2;
	}

	public void play() {
		for (int i = 0; i < rangeOfy; i++) {
			Line row = fillLine();
			this.graphs.add(row);
		}
	}

	private Line fillLine() {
		List<Boolean> row = getFilledFalseList();
		int size = rangeOfx - 1;

		for (int i = 0; i < limitNumberOfLadder; i++) {
			int idx = random.getInt(rangeOfx);
			boolean possible = isFilled(row, size, idx);
			insertTrue(possible, idx, row);
		}
		return new Line(row);
	}

	private void insertTrue(boolean isFilled, int idx, List<Boolean> row) {
		if (isFilled) {
			row.set(idx, true);
		}
	}

	private boolean isFilled(List<Boolean> row, int size, int idx) {
		if (idx == 0) {
			return isDiscontinuous.test(row.get(idx + 1));
		}
		if (idx == size) {
			return isDiscontinuous.test(row.get(idx - 1));
		}
		return isMiddleDiscontinuous(row.get(idx - 1), row.get(idx + 1));
	}

	private boolean isMiddleDiscontinuous(boolean before, boolean next) {
		if (before || next) {
			return false;
		}
		return true;
	}

	private List<Boolean> getFilledFalseList() {
		List<Boolean> filledFalse = IntStream.range(0, rangeOfx)
			.mapToObj(num -> false)
			.collect(toList());
		return filledFalse;
	}

	public List<List<Boolean>> getLadders() {
		return graphs.stream()
			.parallel()
			.map(Line::getPoints)
			.collect(toList());
	}
}
