package domain.player;

import static org.assertj.core.api.Assertions.*;

import domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @Test
    @DisplayName("5자 이하의 이름을 입력하면 플레이어 정상 생성")
    void createPlayer_O() {
        Player p = new Player("honux");
        assertThat(p).isInstanceOf(Player.class);
    }

    @Test
    @DisplayName("5자 초과의 이름을 입력하면 플레이어 생성 실패")
    void createPlayer_X_overLength() {
        assertThatThrownBy(() -> new Player("hohonux"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("플레이어 이름의 최대 길이는 " + Player.MAX_NAME_LENGTH + "입니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "   ", "\t", "\n"})
    @DisplayName("이름을 입력하지 않으면 플레이어 생성 실패")
    void createPlayer_X_nonValue(String input) {
        assertThatThrownBy(() -> new Player(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("플레이어의 이름을 입력해주세요.");
    }
}
