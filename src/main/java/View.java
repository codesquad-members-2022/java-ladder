import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class View {
    private static Scanner sc = new Scanner(System.in);

    public static LadderMap createMap() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = sc.next().split(",");

        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = sc.nextInt();

        List<Ladder> ladderList = Arrays.stream(names)
                .map(name -> new Ladder(name))
                .collect(Collectors.toList());
        return new LadderMap(ladderList, ladderHeight);
    }

}
