package test.com.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderLineTest {
	private static final String VERTICAL_LINE = "|";
	private static final String HORIZONTAL_LINE = "-----";
	private static final String BLANK = "     ";


	void assertLine(String expResult, int column, boolean hasLine) {
		String result = make(column, hasLine);
		assertEquals(expResult, result);
	}

	private String make(int column, boolean hasLine){
		if(column % 2 == 0){
			return VERTICAL_LINE;
		}

		if(hasLine){
			return HORIZONTAL_LINE;
		}

		return BLANK;
	}


	@Test
	void evenColumn() {
		assertLine(VERTICAL_LINE, 0, true);
		assertLine(VERTICAL_LINE, 0, false);
		assertLine(VERTICAL_LINE, 2, true);
		assertLine(VERTICAL_LINE, 2, false);
	}

	@Test
	void oddColumnNotHasLine() {
		assertLine(BLANK, 1, false);
		assertLine(BLANK, 11, false);
	}

	@Test
	void oddColumnHasLine() {
		assertLine(HORIZONTAL_LINE, 1, true);
		assertLine(HORIZONTAL_LINE, 11, true);
	}
}