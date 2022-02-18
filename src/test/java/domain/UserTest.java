package domain;

import domain.user.UserCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("유저 이름의 길이가 범위를 벗어날 경우 예외발생 테스트")
    void nameLengthOutOfBound() {
        assertThatThrownBy(() -> UserCreator.createUserMap(new String[]{"suntory, forky, jerry"}))
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("이름의 길이를 1자 이상, 5자 이하로 작성해주세요.");
    }
}
