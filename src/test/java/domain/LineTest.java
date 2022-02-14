package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class LineTest {

    @Test
    @DisplayName("랜덤boolean 생성 테스트")
    void randTest() {
        Random random = new Random();
        for (int i = 0; i <100 ; i++) {
            System.out.println(random.nextBoolean());
        }
    }

    @Test
    @DisplayName("line 생성 test")
    void generateLine() {
        Line line = new Line();
        Assertions.assertEquals(line.generateLine(true),"-");
        Assertions.assertEquals(line.generateLine(false)," ");
    }
}
