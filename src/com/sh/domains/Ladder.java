package com.sh.domains;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;

import com.sh.utils.Randomz;

public class Ladder {
	private static final int MIN_RANGE = 0;
	private final Integer rangeOfx;
	private final Integer rangeOfy;
	private Randomz random;
	private int place;
	private List<List<Boolean>> graphs = new ArrayList<>();
	private Function<Boolean, Integer> nextDirection = (dir) -> (dir ? -1 : 1);

	public Ladder(Integer rangeOfx, Integer rangeOfy) {
		if (Objects.isNull(rangeOfx) || Objects.isNull(rangeOfy)) {
			throw new NullPointerException("NPE - constructor of Ladder");
		}
		this.rangeOfx = rangeOfx-1;
		this.rangeOfy = rangeOfy;
		this.graphs = new ArrayList<>();
		this.random = Randomz.getInstance();
		this.place = random.getInt(this.rangeOfx);
	}

	public void play() {
		List<Boolean> firstRows = firstLine();
		this.graphs.add(firstRows);
		for (int i = 1; i < rangeOfy; i++) {
			List<Boolean> row = filledNextLines();
			this.graphs.add(row);
		}
	}

	private List<Boolean> filledNextLines() {
		List<Boolean> row = getFilledFalseList();
		nextPlace();
		row.set(this.place, true);
		return row;
	}

	private void nextPlace() {
		boolean directions = random.getBoolean();
		Integer nextPlace = nextDirection.apply(directions);
		if (!isRangeOf(nextPlace)) {
			nextPlace *= (-1);
		}
		this.place += nextPlace;
	}

	private boolean isRangeOf(int point) {
		int nextPlace = this.place + point;
		if (nextPlace < MIN_RANGE || nextPlace >= rangeOfx) {
			return false;
		}
		return true;
	}

	private List<Boolean> firstLine() {
		List<Boolean> row = getFilledFalseList();
		row.set(this.place, true);
		return row;
	}

	private List<Boolean> getFilledFalseList() {
		List<Boolean> filledFalse = IntStream.range(0, rangeOfx)
			.mapToObj(num -> false)
			.collect(toList());
		return filledFalse;
	}

	public List<List<Boolean>> getLadders() {
		return graphs;
	}
}
