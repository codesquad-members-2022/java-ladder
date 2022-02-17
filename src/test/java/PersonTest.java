import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new Person("123456"), "이름의 길이는 5글자가 넘을 수 없습니다.");
    }
}