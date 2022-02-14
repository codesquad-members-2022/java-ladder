import java.util.Scanner;

public class Main {
    private static Ladder ladder;
    private static Person person;

    public static void main(String[] args) {
        // TODO main 메서드 실행 후 참여할 사람, 최대 사다리 높이 입력받을 수 있도록 하기.
        // TODO static 메서드 하나 만들어서 Scanner 로 입력받도록 하자. (Ladder, Person 생성자 사용)
        Main.initOption();

    }

    private static void initOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요 ?");
        int personCount = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        int maxLengthOfLadder = sc.nextInt();

        ladder = new Ladder(maxLengthOfLadder);
        person = new Person(personCount);
    }
}
