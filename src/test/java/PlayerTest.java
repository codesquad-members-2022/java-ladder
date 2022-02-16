import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("5자 이하의 이름을 입력하면 플에이어 정상 생성")
    void createPlayer_O() {
        Player p = new Player("honux");
        assertThat(p).isInstanceOf(Player.class);
    }

    @Test
    @DisplayName("5자 초과의 이름을 입력하면 플에이어 생성 실패")
    void createPlayer_X() {
        assertThatThrownBy(() -> new Player("hohonux"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("플레이어 이름의 최대 길이는 " + Player.MAX_NAME_LENGTH + "입니다.");
    }
}
