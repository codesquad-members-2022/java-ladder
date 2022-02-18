package view;

import game.GameInfo;
import game.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private static String EX_NUMBER_MESSAGE = "사람이름은 최대 5글자까지";
    private static String FIND_PEOPLE_MESSAGE = "참여할 사람의 이름을 입력하세요. (이름은 쉼포로 구분하세요)";
    private static String FIND_HEIGHT_MESSAGE = "최대 사다리 높이는 몇개인가요?";
    private static Scanner sc = new Scanner(System.in);
    private GameRepository gameRepository = GameRepository.getInstance();

    public void startGame() {
        StringTokenizer st = new StringTokenizer(getPeople(), ",");
        List<String> playerList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            playerList.add(validNameLength(st));
        }
        gameRepository.save(new GameInfo(playerList.size(), getHeight(), playerList));
    }

    private String validNameLength(StringTokenizer st) {
        String player = st.nextToken();
        if (player.length() > 5){
            throw new IllegalStateException(EX_NUMBER_MESSAGE);
        }
        return player;
    }

    private int getHeight() {
        System.out.println(FIND_HEIGHT_MESSAGE);
        int height = sc.nextInt();
        return height;
    }

    private String getPeople() {
        System.out.println(FIND_PEOPLE_MESSAGE);
        String people = sc.next();
        return people;
    }

    public void close() {
        sc.close();
    }
}
