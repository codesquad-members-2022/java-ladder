package domain.player;

import static org.assertj.core.api.Assertions.*;

import domain.player.PlayerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerListTest {

    @Test
    @DisplayName("유효한 이름만 입력하여 플레이어 리스트 생성")
    void createPlayerList_O() {
        PlayerList players = PlayerList.of("pobi", "hohonux", "crong", "jk");
        assertThat(players.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("유효하지 않은 이름을 포함하면 플레이어 리스트 생성 실패")
    void createPlayerList_X() {
        assertThatThrownBy(() -> PlayerList.of("pobi", "hohonux", "crong", "jk", " "))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
