package application.view;

import application.domain.ladder.Ladder;
import application.domain.player.Player;
import application.util.InputUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @ParameterizedTest()
    @ValueSource(strings = { "geombong,dukcode,leekm0310,who-hoo,Dave,donggi,Riako"
            , "ge,dukc,leekm,who,Dave,don,Riako", "ge,du,le,wh,Da,do,Ri" })

    void getPlayers(String input) {
        List<Player> players = InputUtils.getPlayers(input);
        for (Player player : players) {
            assertThat(player.toString().length()).isEqualTo(Ladder.INTERVAL + 1);
        }
    }
}