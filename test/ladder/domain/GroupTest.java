package ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class GroupTest {
    static final List<String[]> DUMMY_INPUT = List.of(
            new String[]{"ABC", "RATHALOS", "GOLEM", "BEAST"},
            new String[]{"HANNAH", "JK", "HONUX", "FLOWER", "GOAT"},
            new String[]{"HAHAHAHA", "MADNESS", "STRANGE"}
    );
    final SoftAssertions softly = new SoftAssertions();

    Group group;

    @ParameterizedTest
    @CsvSource({
            "0, 4",
            "1, 5",
            "2, 3"
    })
    @DisplayName("생성자에 길이가 지정되지 않았을 때 만들어진 객체의 이름 갯수 카운트")
    void count(int dummyInputIndex, int expected) {
        group = new Group(DUMMY_INPUT.get(dummyInputIndex));
        softly.assertThat(group.count()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 5",
            "1, 6",
            "2, 7"
    })
    @DisplayName("생성자에 길이가 지정되었을 때 만들어진 객체의 이름 갯수 카운트")
    void countFixedLength(int dummyInputIndex, int expected) {
        group = new Group(DUMMY_INPUT.get(dummyInputIndex), expected);
        softly.assertThat(group.count()).isEqualTo(expected);
    }
}
