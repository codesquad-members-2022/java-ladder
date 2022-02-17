package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class HashSetTest {

    @Test
    public void hashSet() {
        HashSet<Point> points = new HashSet<>();
        points.add(Point.of(1, 1));
        points.add(Point.of(2, 2));
        points.add(Point.of(3, 3));

        // 요구사항 1 : HashSet의 모든 element를 출력한다.
        System.out.println(points);
        assertThat(points)
            .containsExactly(
                Point.of(1, 1),
                Point.of(2, 2),
                Point.of(3, 3)
            );

        // 요구사항 2 : HashSet에서 new Point(1, 1)를 제거한다.
        points.remove(Point.of(1, 1));
        System.out.println("remove (1, 1) => " + points);
        assertThat(points)
            .containsExactly(
                Point.of(2, 2),
                Point.of(3, 3)
            );

        // 요구사항 3 : HashSet에 new Point(2, 2)를 추가한 후 모든 element 개수를 출력한다.
        points.add(Point.of(2, 2));
        System.out.println("add (2, 2) => " + points);
        assertThat(points)
            .containsExactly(
                Point.of(2, 2),
                Point.of(3, 3)
            );
        assertThat(points.size()).isEqualTo(2);
        System.out.println("points count = " + points.size());
    }
}
