import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static Scanner input = new Scanner(System.in);
    private static final int ValidNameLength = 5;

    public static int getUserNumberInput(){
        OutputView.printUserNumberMessage();
        return input.nextInt();
    }

    public static int getSadariNumberInput(){
        OutputView.printSadariNumberMessage();
        return input.nextInt();
    }

    public static String[] getUsersNames(){
        OutputView.printUserNamesMessage();
        String[] userNamesInputLine = input.nextLine().split(",");
        while(isNamesHaveValidLength( userNamesInputLine ) != true) {
            OutputView.printInvalidUserNamesMessage();
            userNamesInputLine = input.nextLine().split(",");
        }
        return userNamesInputLine;
    }

    private static boolean isNamesHaveValidLength(String[] userNames){
        return Arrays.stream(userNames).filter(i -> i.length()>ValidNameLength).count() > 0 ? false : true;
    }
}
