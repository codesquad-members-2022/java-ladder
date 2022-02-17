package LadderGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static Scanner sc = new Scanner(System.in);
    private static List<String> userList;
    public Client() {
    }

    public void run() {

        inputUser();

        LadderGame ladderGame = new LadderGame();

        ladderGame.init(getUserCount(), getLadderHeight());

        sc.close();
    }

    public List<String> getUserList() {
        return userList;
    }

    private int getLadderHeight() {
        printLadderCountNotification();
        return sc.nextInt();
    }

    private void inputUser() {
        printUserCountNotification();
        userList = new ArrayList<>(Arrays.asList(sc.nextLine().trim().split(",")));
    }

    private int getUserCount() {
        return userList.size();
    }

    private static void printUserCountNotification() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static void printLadderCountNotification() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}
