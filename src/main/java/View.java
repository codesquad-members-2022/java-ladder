import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static Scanner sc = new Scanner(System.in);

    public static LadderMap createMap() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int personCount = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();
        return new LadderMap(personCount, ladderHeight);
    }

    public static void printLadderMap(char[][] map) {
        System.out.println();
        for (char[] line : map) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
