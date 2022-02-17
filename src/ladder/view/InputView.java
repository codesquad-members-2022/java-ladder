package ladder.view;

import ladder.domain.user.Name;
import ladder.domain.user.Names;
import ladder.domain.ladder.Height;
import ladder.system.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\nex) pobi,honux,crong,jk\n";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?\n5\n";
    private static final String COMMA = ",";
    static BufferedReader bufferReader = Configuration.bufferReader;

    private InputView() {}

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        if (instance == null) {
            return new InputView();
        }
        return instance;
    }

    public Names getPlayerNames() throws IOException {
        out.println(INPUT_PLAYER_NAMES);
        String input = bufferReader.readLine();
        return getNames(input);
    }

    private Names getNames(String input) throws IOException {
        try {
            List<Name> names = Arrays.stream(input.split(COMMA))
                    .map(String::trim)
                    .map(Name::new)
                    .collect(toList());
            return new Names(names);
        } catch (Exception e) {
            out.println("");
            return getPlayerNames();
        }
    }

    public Height getHeight() {
        out.println(INPUT_LADDER_HEIGHT);
        return new Height(5);
    }
}
