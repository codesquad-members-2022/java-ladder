package ladder.test;

import ladder.domain.LadderGameManager;
import ladder.view.InputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    public void 닉네임이_최대길이까지만_출력된다() {
        //given
        String[] playerNames = {"suntory", "ddmouse", "nathan"};

        //when
        String[] result = InputView.cutToMaximumLength(playerNames, 5);

        //then
        for (int i = 0; i < playerNames.length; i++) {
            if (playerNames[i].length() > LadderGameManager.MAX_NAME_LENGTH) {
                StringBuilder sb = new StringBuilder(playerNames[i].substring(0, 3));
                sb.append("..");
                Assertions.assertEquals(sb.toString(), result[i]);
                System.out.println(sb.toString() + " " + result[i]);
            }
        }
    }
}
