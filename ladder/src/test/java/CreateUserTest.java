import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import exception.WrongInputException;
import model.User;
import model.game.LadderGame;
import repository.UserRepository;

class CreateUserTest {
    UserRepository userRepository = UserRepository.getInstance();

    @BeforeEach
    void clearTest() {
        userRepository.clear();
    }

    @Test
    @DisplayName("유저 생성 테스트")
    void createUserTest() {
        LadderGame game = new LadderGame();
        String username = "pobi,honux,crong,jk";
        game.createUser(username);
        List<Boolean> nameCheck = new ArrayList<>();
        for (User e : userRepository.findAllUser()) {
            nameCheck.add(e.isSameUsername(e.toString()));
        }
        assertThat(nameCheck).hasSize(4).doesNotContain(false);
    }

    @Test
    @DisplayName("유저 이름 공백체크 기능 테스트")
    void usernameBlankCheckTest() {
        LadderGame game = new LadderGame();
        String username = "  ,pobi,honux,crong,jk";

        assertThatThrownBy(() -> {
            game.createUser(username);
        }).isInstanceOf(WrongInputException.class);
    }

    @Test
    @DisplayName("유저 이름 길이 체크 테스트")
    void usernameLengthCheck() {
        LadderGame game = new LadderGame();
        String username = "geombong";
        String resultName = "geo..";
        game.createUser(username);

        for (var u : userRepository.findAllUser()) {
            assertThat(u.isSameUsername(resultName)).isTrue();
        }
    }

    @Test
    @DisplayName("유저 중복 등록 체크 테스트")
    void userDuplicateCheckTest() {
        LadderGame game = new LadderGame();
        String username = "jk,jk,pobi,honux,crong";


        assertThatThrownBy(() -> {
            game.createUser(username);
        }).isInstanceOf(WrongInputException.class);
    }
}
