package application.util;

import application.domain.ladder.Ladder;
import application.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {

    @ParameterizedTest()
    @ValueSource(strings = { "geombong,dukcode,leekm0310,who-hoo,Dave,donggi,Riako"
            , "ge,dukc,leekm,who,Dave,don,Riako", "ge,du,le,wh,Da,do,Ri" })
    @DisplayName("플레이어 이름에서 최대 5글자('..' 채움)를 출력한다.")
    void getPlayers(String input) {
        List<Player> players = InputUtils.getPlayers(input);
        for (Player player : players) {
            assertThat(player.toString().length()).isEqualTo(Ladder.INTERVAL + 1);
        }
    }
}