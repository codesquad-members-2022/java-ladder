package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.user.User;

import java.util.List;

public class OutputUtil {
    private static final String USER_LINE = "|";
    private static final String CONNECTION_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public static void printUsers(List<User> users) {
        users.forEach(user -> System.out.print(user + " "));
    }


    public static void printLadder(Ladder ladder) {
            //각 줄별로 출력
    }

    public static void printResults() {
        //Result를 담은 List를 매개변수로 받는다
        //출력
    }

    private static void printLadderLine(Line line) {
        //반복문으로 line을 돌면서
        //-1 = 빈칸
        //0 = 유저
        //1 = 연결선
        //으로 만들어서 반환
    }
}
