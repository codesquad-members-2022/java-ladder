package view;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {

    @Test
    @DisplayName("이름과 padding을 포함하여 총 6글자를 출력하는지 확인")
    void printNames() {
        //given
        String name1 = "a";
        String name2 = "abc";
        String name3 = "abcde";
        Output output = new Output();
        List<String> processedNames = new ArrayList<>();

        //when
        int length = 6;

        //then
        assertThat(output.addPadding(name1, length)).hasSize(length);
        assertThat(output.addPadding(name2, length)).hasSize(length);
        assertThat(output.addPadding(name3, length)).hasSize(length);
    }

}