package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {

    Scanner sc;

    public UserInterface() {
        sc = new Scanner(System.in);
    }

    public List<String> inputPlayerList() {
        String userInput = "";
        boolean inputFlag = true;
        while (inputFlag) {
            GameDisplay.guideInputPlayerName();
            userInput = sc.nextLine();
            inputFlag = checkPlayerListInput(userInput); // 사용자 입력 검증 후 올바를 경우 while break
        }

        return getPlayerList(userInput);
    }

    public int inputLadderHeight() {
        GameDisplay.guideInputLadderHeight();
        return Integer.parseInt(sc.nextLine());
    }

    private boolean checkPlayerListInput(String userInput) {
        String inputPattern = "^([^,\s]{1,5})+(,([^,\s]{1,5}))*$";
        if (!Pattern.matches(inputPattern, userInput)) {
            GameDisplay.showError();
            return true;
        }
        return false;
    }

    private List<String> getPlayerList(String input) {
        List<String> arrayList = new ArrayList<>();
        String[] players = input.split(",");
        for (int i = 0; i < players.length; i++) {
            arrayList.add(players[i]);
        }

        return arrayList;
    }
}
