package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    private String[] users;

    @Test
    @DisplayName("유저 이름의 길이가 범위를 벗어날 경우 예외발생 테스트")
    void nameLengthOutOfBound() {
        users = new String[]{"jerry", "suntory", "forky", "whi"};

        assertThatThrownBy(() -> new User(users))
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("이름의 길이를 1자 이상, 5자 이하로 작성해주세요.");
    }

    @Test
    @DisplayName("이름의 길이가 1자일 경우 공백을 넣어서 5자로 채워주는 테스트")
    void addPaddingToLengthOne() {
        users = new String[]{"a", "b", "c"};
        User userlist = new User(users);

        List<String> sut = userlist.getUsers();

        sut.forEach(name -> {
            assertThat(name.length()).isEqualTo(5);
        });
    }

    @Test
    @DisplayName("이름의 길이가 2자일 경우 공백을 넣어서 5자로 채워주는 테스트")
    void addPaddingToLengthTwo() {
        users = new String[]{"aa", "bb", "cc"};
        User userlist = new User(users);

        List<String> sut = userlist.getUsers();

        sut.forEach(name -> {
            assertThat(name.length()).isEqualTo(5);
        });
    }

    @Test
    @DisplayName("이름의 길이가 3자일 경우 공백을 넣어서 5자로 채워주는 테스트")
    void addPaddingToLengthThree() {
        users = new String[]{"aaa", "bbb", "ccc"};
        User userlist = new User(users);

        List<String> sut = userlist.getUsers();

        sut.forEach(name -> {
            assertThat(name.length()).isEqualTo(5);
        });
    }

    @Test
    @DisplayName("이름의 길이가 4자일 경우 공백을 넣어서 5자로 채워주는 테스트")
    void addPaddingToLengthFour() {
        users = new String[]{"aaaa", "bbbb", "cccc"};
        User userlist = new User(users);

        List<String> sut = userlist.getUsers();

        sut.forEach(name -> {
            assertThat(name.length()).isEqualTo(5);
        });
    }


}
