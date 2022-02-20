package com.sh.domains.ladders;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import com.sh.utils.Randomz;

public class Ladder {
	private final int lengthOfHead;
	private final int rangeOfx;
	private final int rangeOfy;
	private Randomz random;
	private int limitNumberOfLadder;
	private List<Line> graphs = new ArrayList<>();

	public Ladder(int rangeOfx, int rangeOfy) {
		if (Objects.isNull(rangeOfx) || Objects.isNull(rangeOfy)) {
			throw new NullPointerException("NPE - constructor of Ladder");
		}
		this.lengthOfHead = rangeOfx;
		this.rangeOfx = rangeOfx - 1;
		this.rangeOfy = rangeOfy;
		this.graphs = new ArrayList<>();
		this.random = Randomz.getInstance();
		this.limitNumberOfLadder = halfLengthInWidth();
	}

	private int halfLengthInWidth() {
		return this.rangeOfx / 2;
	}

	public void build() {
		for (int i = 0; i < rangeOfy; i++) {
			Line row = fillLine();
			this.graphs.add(row);
		}
	}

	public List<Integer> playersResult() {
		List<Integer> resultIdxs = new ArrayList<>();
		for (int i = 0; i < lengthOfHead; i++) {   // i는 player 각각의 순서를 의미한다
			int playerIdx = i;
			playerIdx = doLadderGame(playerIdx);
			resultIdxs.add(playerIdx);
		}
		return resultIdxs;
	}

	/**
	 * 입력받은 playerIdx 시작 위치에서 사다리 유무에 따라 다른 idx로 이동하면서 결과값을 얻습니다.
	 *  - PlayerIdx 5일 경우 사다리는 List 내에서 0~3의 범위로 값을 가집니다.
	 *  - 이를 맞추기 위해
	 *    - playerIdx = 0일때 우측 유무 확인
	 *    - playerIdx=5일때 좌측 유무 확인
	 *    - 중간은 양쪽으로 -1/+1 유무확인
	 *    - 이동 중 0이하, 최대수5를 넘지 않도록 합니다.
	 * @param playerIdx
	 * @return
	 */
	private int doLadderGame(int playerIdx) {  //  TODO 10줄 넘는다...
		for (int j = 0; j < rangeOfy; j++) {
			Line line = graphs.get(j);
			int left = withinRange(playerIdx - 1);
			int right = withinRange(playerIdx);

			if (playerIdx == 0) {
				playerIdx = moveFromFirstToSecond(playerIdx, right, line);
				continue;
			}
			if (playerIdx == rangeOfx) {
				playerIdx = moveFromLastToBefore(playerIdx, left, line);
				continue;
			}
			playerIdx = toLeftOrRightInMiddle(playerIdx, left, right, line);
		}
		return playerIdx;
	}

	private int moveFromFirstToSecond(int playerIdx, int right, Line line) {
		List<Boolean> isLadder = line.getPoints();
		Boolean toRight = isLadder.get(right);
		if (toRight) {
			playerIdx += 1;
		}
		return playerIdx;
	}

	private int moveFromLastToBefore(int playerIdx, int left, Line line) {
		List<Boolean> isLadder = line.getPoints();
		Boolean toLeft = isLadder.get(left);
		if (toLeft) {
			playerIdx -= 1;
		}
		return playerIdx;
	}

	private int toLeftOrRightInMiddle(int playerIdx, int left, int right, Line line) {
		List<Boolean> isLadder = line.getPoints();
		Boolean toLeft = isLadder.get(left);
		Boolean toRight = isLadder.get(right);
		if (toLeft) {
			playerIdx = withinRangeOfPlayer(playerIdx - 1);
		} else if (toRight) {
			playerIdx = withinRangeOfPlayer(playerIdx + 1);
		}
		return playerIdx;
	}

	private int withinRange(int idx) {
		if (idx < 0) {
			return 0;
		}
		if (idx >= rangeOfx) {
			return idx - 1;
		}
		return idx;
	}

	private int withinRangeOfPlayer(int playerNextIdx) {
		if (playerNextIdx < 0) {
			return 0;
		}
		if (playerNextIdx >= lengthOfHead) {
			return lengthOfHead - 1;
		}
		return playerNextIdx;
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
