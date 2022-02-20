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

	/**
	 * 사다리 가로길이 절반만큼의 사다리 생성 합니다 (중복된 값이 없을 확율)
	 * - 생성될 라인은 Boolean 타입으로 false로 초기화 합니다. (true : 사다리 O, false : 사다리 X)
	 * - insertLadder() 를 통해 특정위치 값을 True로 변경 : 사다리 삽입
	 * @return Line
	 */
	private Line fillLine() {
		List<Boolean> row = getFilledFalseList();
		int size = rangeOfx - 1;

		for (int i = 0; i < limitNumberOfLadder; i++) {
			int idx = random.getInt(rangeOfx);
			boolean possible = isFilled(row, size, idx);
			insertLadder(possible, idx, row);
		}
		return new Line(row);
	}

	private void insertLadder(boolean isFilled, int idx, List<Boolean> row) {
		if (isFilled) {
			row.set(idx, true);
		}
	}

	// private Predicate<Boolean> isDiscontinuous = (bool) -> (bool ? false : true);


	private boolean isFilled(List<Boolean> row, int size, int idx) {
		Discontinuous isDiscontinuous = getIsDiscontinuous();
		if (idx == 0) {
			return isDiscontinuous.test(row.get(idx + 1));
		}
		if (idx == size) {
			return isDiscontinuous.test(row.get(idx - 1));
		}
		return isMiddleDiscontinuous(row.get(idx - 1), row.get(idx + 1));
	}

	private Discontinuous getIsDiscontinuous() {
		return new Discontinuous() {
			@Override
			public boolean test(boolean nextLadder) {
				return (nextLadder ? false : true);
			}
		};
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
