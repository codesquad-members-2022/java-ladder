package ladder.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {

    Scanner sc;

    public UserInterface() {
        sc = new Scanner(System.in);
    }

    public ArrayList<String> inputPlayerList() {
        GameDisplay.guideInputPlayerName();
        String userInput = sc.nextLine();
        if (checkInput(userInput)) return null;

        return getPlayerList(userInput);
    }

    public int inputLadderHeight() {
        GameDisplay.guideInputLadderHeight();
        return Integer.parseInt(sc.nextLine());
    }

    private boolean checkInput(String userInput) {
        String inputPattern = "^([^,\s]{1,5})+(,([^,\s]{1,5}))*$";
        if (!Pattern.matches(inputPattern, userInput)) {
            GameDisplay.showError();
            return true;
        }
        return false;
    }

    private ArrayList<String> getPlayerList(String input) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] players = input.split(",");
        for (int i = 0; i < players.length; i++) {
            arrayList.add(players[i]);
        }

        return arrayList;
    }

}
