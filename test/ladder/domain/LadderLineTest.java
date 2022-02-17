package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

	@Test
	@DisplayName("사다리 좌우 발판 동시 생성 불가능 테스트")
	void test() {
		LadderLine ladderLine = new LadderLine(100);
		assertFalse(ladderLine.toString().contains("|-----|-----|"));
	}

}