package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    public void hashMap() {
        HashMap<Integer, Point> points = new HashMap<>();
        points.put(1, Point.of(1, 1));
        points.put(2, Point.of(3, 5));
        points.put(3, Point.of(5, 7));

        System.out.println("points => " + points);

        // 요구사항 1 : HashMap에서 key가 2에 해당하는 Point 객체를 찾아 출력한다.
        System.out.println("search 2 => " + points.get(2));
        assertThat(points.get(2)).isEqualTo(Point.of(3, 5));

        // 요구사항 2 : HashMap의 Key는 4, Value는 new Point(10, 15)를 추가하고, HashMap의 모든 Value 값을 출력한다.
        points.put(4, Point.of(10, 15));
        System.out.println("add 4: (10, 15) => " + points);
        assertThat(points)
            .containsAllEntriesOf(Map.of(
                1, Point.of(1, 1),
                2, Point.of(3, 5),
                3, Point.of(5, 7),
                4, Point.of(10, 15))
            );

        // 요구사항 3 : HashMap의 Key가 3인 값을 삭제한 후, HashMap의 모든 Value 값을 출력한다.
        points.remove(3);
        System.out.println("remove 3 => " + points);
        assertThat(points)
            .containsAllEntriesOf(Map.of(
                1, Point.of(1, 1),
                2, Point.of(3, 5),
                4, Point.of(10, 15))
            );

        // 요구사항 4 : HashMap의 모든 Key와 Value를 출력한다.
        System.out.println("points => " + points);
        assertThat(points)
            .containsAllEntriesOf(Map.of(
                1, Point.of(1, 1),
                2, Point.of(3, 5),
                4, Point.of(10, 15))
            );
    }
}
