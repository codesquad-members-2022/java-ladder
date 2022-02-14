import java.util.Scanner;

public class UserInterface {

    Scanner sc;

    UserInterface() {
        sc = new Scanner(System.in);
    }

    public int inputPersonCount() {
        GameDisplay.showGuideToPersonCount();
        return Integer.parseInt(sc.nextLine());
    }

    public int inputLadderCount() {
        GameDisplay.showGuideToLadderHeight();
        return Integer.parseInt(sc.nextLine());
    }

}
