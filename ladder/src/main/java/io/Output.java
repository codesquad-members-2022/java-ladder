package io;

import java.util.List;

import model.Line;
import model.User;

public class Output {

    private static final String USER_COUNT = "참여할 사람은 몇 명인가요?";
    private static final String LADDER_MAX_HIGH = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_USERNAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public int printUserCountBar(Input input) {
        System.out.println(USER_COUNT);
        return input.inputInteger();
    }

    public int printLadderMaxHighBar(Input input) {
        System.out.println(LADDER_MAX_HIGH);
        return input.inputInteger();
    }

    public String printInputUsernameBar(Input input) {
        System.out.println(INPUT_USERNAME);
        return input.inputString().trim();
    }

    public void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.println(line.toString());
        }
    }

    public void printUser(List<User> allUser) {
    }
}
