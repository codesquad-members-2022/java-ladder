package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

	@Test
	@DisplayName("사다리 좌우 발판 동시 생성 불가능 확인")
	void ladderStepSeparateTest() {
		LadderLine ladderLine = new LadderLine(100);
		assertThat(ladderLine.toString()).doesNotContain("|-----|-----|");
	}

}