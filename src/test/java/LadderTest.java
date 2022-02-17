import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

//    @Test
//    void initMap() {
//        String[] names = {"pobi","honux","crong","jk"};
//        List<Person> personList = Arrays.stream(names).map(name -> new Person(name)).collect(Collectors.toList());
//
//        Ladder ladder = new Ladder(personList, names.length);
//        List<Line> map = ladder.getMap();
//        String firstMapLine = map.get(0);
//
//        for (String name : names) {
//            assertTrue(firstMapLine.contains(name));
//        }
//
//        for (int i = 1; i < map.size(); i++) {
//            String mapLine = map.get(i);
//            for (int j = 0; j < ladder.getPersonCount(); j++) {
//                String s = mapLine.substring(j * 6, (j + 1) * 6);
//                assertTrue(s.equals("-----|") || s.equals("     |"));
//            }
//        }
//    }
}