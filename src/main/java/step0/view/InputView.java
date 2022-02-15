package step0.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Integer> requestInfo() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int personNumbers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();
        return Arrays.asList(personNumbers, ladderHeight);
    }
}
