package ladder.view;

import ladder.model.Name;
import ladder.model.Names;
import ladder.model.ladder.Height;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\nex) pobi,honux,crong,jk\n";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?\n5";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String COMMA = ",";

    private InputView() {
    }

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        if (instance == null) {
            return new InputView();
        }
        return instance;
    }

    public Names getPlayerNames() throws IOException {

        out.println(INPUT_PLAYER_NAMES);
        List<Name> widthAndHeight = new ArrayList<>();
        String input = br.readLine();

        List<Name> names = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(Name::new)
                .collect(toList());
        return new Names(names);
    }

    public Height getHeight() {
        return new Height(3);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");


}
