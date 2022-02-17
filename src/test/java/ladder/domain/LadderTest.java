package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("coordinate의 범위는 0에서 personCount - 1 사이여야 한다다.")
    void initMap() {
        String[] names = {"pobi", "honux", "crong", "jk"};
        List<Person> personList = Arrays.stream(names)
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        Ladder ladder = new Ladder(personList, 100);
        List<Line> lineList = ladder.getLineList();

        int personCount = ladder.getPersonCount();
        for (Line line : lineList) {
            int coordinate = line.getCoordinate();
            assertTrue(0 <= coordinate && coordinate <= personCount - 1);
        }
    }
}