package com.sh;

import java.util.Objects;
import java.util.stream.IntStream;

import com.sh.utils.RandomNumber;

public class Ladder {
	private final Integer rangeOfx;
	private final Integer rangeOfy;
	private boolean[][] graphs = null;
	private RandomNumber randomNumber;

	public Ladder(Integer rangeOfx, Integer rangeOfy) {
		if (Objects.isNull(rangeOfx) || Objects.isNull(rangeOfy)) {
			throw new RuntimeException("NPE - constructor of Ladder");
		}
		this.rangeOfx = rangeOfx-1;
		this.rangeOfy = rangeOfy;
		this.graphs = new boolean[rangeOfy][this.rangeOfx];
		this.randomNumber = RandomNumber.getInstance();
	}

	public void play() {
		IntStream.range(0, rangeOfy)
			.forEach(y -> {
				int nextNo = randomNumber.getInt(this.rangeOfx);
				graphs[y][nextNo] = true;
			});
	}

	public boolean[][] getLadders() {
		return graphs;
	}
}
