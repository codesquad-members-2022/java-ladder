package view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 이름을최대5글자만출력하는지(){
        //given
        String[] userNames = {"a", "bbbbb", "cccccc"};
        String answer = "a bbbbb ccccc";

        //when
        OutputView.printUserNames( userNames );

        //then
        Assertions.assertEquals(answer, outputStreamCaptor.toString().trim());
    }



    @Test
    void 이름길이를5글자까지만입력받는지(){
        //given
        //when
        //then
    }

}