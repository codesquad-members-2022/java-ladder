import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static Scanner sc = new Scanner(System.in);

    public static Ladder createLadder() {
        String[] personNames = getNames();
        List<Person> personList = Arrays.stream(personNames)
                .map(name -> new Person(name))
                .collect(Collectors.toList());

        int ladderHeight = getLadderHeight();
        return new Ladder(personList, ladderHeight);
    }

    private static int getLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();
        return ladderHeight;
    }

    private static String[] getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = sc.next().split(",");
        return names;
    }

    public static void printMap(List<String> map) {
        System.out.println("\n실행 결과\n");
        map.stream().forEach(System.out::println);
    }
}
