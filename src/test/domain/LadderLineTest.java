package test.domain;

import static org.junit.jupiter.api.Assertions.*;

import main.domain.LadderElement;
import main.domain.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

    private static final int EVEN_IND = 0;
    private static final int ODD_IND = 1;

    @Test
    @DisplayName("VERTICAL 확인 1")
    public void verticalTest_1() {
        boolean next = false;
        boolean rand = false;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(EVEN_IND, next, rand);
        assertEquals(element, LadderElement.VERTICAL);
    }

    @Test
    @DisplayName("VERTICAL 확인 2")
    public void verticalTest_2() {
        boolean next = false;
        boolean rand = true;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(EVEN_IND, next, rand);
        assertEquals(element, LadderElement.VERTICAL);
    }

    @Test
    @DisplayName("VERTICAL 확인 3")
    public void verticalTest_3() {
        int ind = 0;
        boolean next = true;
        boolean rand = false;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(EVEN_IND, next, rand);
        assertEquals(element, LadderElement.VERTICAL);
    }

    @Test
    @DisplayName("VERTICAL 확인 4")
    public void verticalTest_4() {
        int ind = 0;
        boolean next = true;
        boolean rand = true;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(EVEN_IND, next, rand);
        assertEquals(element, LadderElement.VERTICAL);
    }

    @Test
    @DisplayName("BLANK 확인 1")
    public void blankTest_1() {
        boolean next = false;
        boolean rand = true;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(ODD_IND, next, rand);
        assertEquals(element, LadderElement.BLANK);
    }

    @Test
    @DisplayName("BLANK 확인 2")
    public void blankTest_2() {
        boolean next = false;
        boolean rand = true;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(ODD_IND, next, rand);
        assertEquals(element, LadderElement.BLANK);
    }

    @Test
    @DisplayName("BLANK 확인 3")
    public void blankTest_3() {
        boolean next = true;
        boolean rand = false;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(ODD_IND, next, rand);
        assertEquals(element, LadderElement.BLANK);
    }

    @Test
    @DisplayName("HORIZONTAL 확인 1")
    public void blankTest_4() {
        boolean next = true;
        boolean rand = true;

        LadderLine line = new LadderLine(0);
        LadderElement element = line.add(ODD_IND, next, rand);
        assertEquals(element, LadderElement.HORIZONTAL);
    }

}