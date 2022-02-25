package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Line 객체 Test")
class LineTest {

    @DisplayName("Line이 생성될 때, 입력 받은 사람 수보다 1이 작게 원소를 생성하는가")
    @Test
    void sizeTest() {
        Line line1 = new Line(2);
        Line line2 = new Line(22);
        Line line3 = new Line(222);
        assertEquals(1, line1.size());
        assertEquals(21, line2.size());
        assertEquals(221, line3.size());
    }

    @DisplayName("Line이 생성될 때, 원소들이 Boolean 값으로 잘 들어갔는가")
    @Test
    void isNotEmpty() {
        Line line = new Line(3);
        for (int i = 0; i < line.size(); i++) {
            assertEquals("java.lang.Boolean", line.get(i).getClass().getName());
        }
    }

    @DisplayName("Line.get()의 파라미터로 음수 인덱스가 주어졌을 때, 예외처리 메시지가 잘 출력되는가")
    @Test
    void negativeParam() {
        Line line = new Line(3);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                line.get(-1));
        assertEquals("1이상의 Line 길이 내에서만 값을 얻을 수 있습니다.", exception.getMessage());
    }

    @DisplayName("Line 객체에서 이전 값이 True(발판있음)이면, False(발판없음)을 리턴하는가")
    @Test
    void overLapTest() {
        Line line = new Line(100);
        for (int i = 1; i < line.size(); i++) {
            if(line.get(i)){
                assertNotSame(line.get(i), line.get(i - 1));
            }
        }
    }
}