import java.util.Scanner;

public class InputView {
    private static Scanner input = new Scanner(System.in);

    public static int getUserNumberInput(){
        OutputView.printUserNumberMessage();
        return input.nextInt();
    }

    public static int getSadariNumberInput(){
        OutputView.printSadariNumberMessage();
        return input.nextInt();
    }

    public static String[] getUsersNames(){
        String userNamesInputLine = input.nextLine();
        return userNamesInputLine.split(",");
    }
}
