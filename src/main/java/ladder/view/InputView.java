package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static Ladder createLadder() {
        String[] personNames = getPersonNames();
        List<Person> personList = getPersonList(personNames);

        int ladderHeight = getLadderHeight();
        return new Ladder(personList, ladderHeight);
    }

    private static List<Person> getPersonList(String[] personNames) {
        return Arrays.stream(personNames)
                .map(name -> new Person(name))
                .collect(Collectors.toList());
    }

    private static int getLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();
        return ladderHeight;
    }

    private static String[] getPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = sc.next().split(",");
        return names;
    }
}
