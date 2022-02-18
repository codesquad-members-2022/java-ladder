package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("유저 이름의 길이가 범위를 벗어날 경우 예외발생 테스트")
    void nameLengthOutOfBound() {

        assertThatThrownBy(() -> User.createUser("suntory",0))
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("이름의 길이를 1자 이상, 5자 이하로 작성해주세요.");
    }

    @Test
    @DisplayName("이름의 길이가 5자가 아닐경우 공백으로 채워주는 테스트")
    void addPaddingToUsername() {
        List<String> usernames = Arrays.asList("a","aa", "aaa", "aaaa");

        usernames.forEach(name->{
            String sut = User.createUser(name,0).getName();
            assertThat(sut.length()).isEqualTo(5);
        });
    }
}
