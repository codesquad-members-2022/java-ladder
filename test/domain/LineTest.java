package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Line 객체 Test")
class LineTest {

    @DisplayName("Line.size()가 정상적으로 나오는가")
    @Test
    void sizeTest() {
        Line line1 = new Line(2);
        Line line2 = new Line(22);
        Line line3 = new Line(222);
        assertEquals(1, line1.size());
        assertEquals(21, line2.size());
        assertEquals(221, line3.size());
    }

    @DisplayName("Line이 제대로 생성이 되는가(원소들이 Boolean 값으로 잘 들어갔는가)")
    @Test
    void isNotEmpty() {
        Line line = new Line(3);
        for (int i = 0; i < line.size(); i++) {
            assertEquals("java.lang.Boolean", line.get(i).getClass().getName());
        }
    }

    @DisplayName("Line.get()의 파라미터로 음수 인덱스가 주어졌을 때 예외처리가 잘 되는가")
    @Test
    void negativeParam() {
        Line line = new Line(3);
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                line.get(-1));
        assertEquals("java.lang.IndexOutOfBoundsException", exception.toString());
    }

    @DisplayName("Line 객체에서 선이 겹치는지 여부 판단")
    @Test
    void overLapTest() {
        Line line = new Line(100);
        for (int i = 1; i < line.size(); i++) {
            if(line.get(i)){
                assertEquals(false, line.get(i) == line.get(i-1));
            }
        }
    }
}