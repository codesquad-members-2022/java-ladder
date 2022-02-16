import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static int getInputNumer(String message) {
        OutputView.printMessage(message);
        return scanner.nextInt();
    }

    public static void close() {
        scanner.close();
    }

    public static List<Player> getInputPlayers(String message) {
        OutputView.printMessage(message);

        List<Player> players = new ArrayList<>();

        String[] names = scanner.nextLine().split(",");

        for (String name : names) {
            players.add(Player.createPlayerWithName(name));
        }

        return players;
    }
}
