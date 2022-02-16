import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import model.User;
import model.ladder.LadderGame;
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
}
