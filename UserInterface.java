package step2;

import java.util.Scanner;

public class UserInterface {

    Scanner sc;

    UserInterface() {
        sc = new Scanner(System.in);
    }

    public int inputPlayerCnt() {
        GameDisplay.showGuideToPlayerCnt();
        return Integer.parseInt(sc.nextLine());
    }

    public int inputLadderHeight() {
        GameDisplay.showGuideToLadderHeight();
        return Integer.parseInt(sc.nextLine());
    }

}
