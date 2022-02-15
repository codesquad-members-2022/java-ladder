import java.util.Scanner;

public class Main {
    private static Ladder ladder;
    private static Person person;
    private static Output output;

    public static void main(String[] args) {
        Main.initOption();
        char[][] resultLadder = ladder.initLadderInformation();
        output.printLadder(resultLadder);
    }

    private static void initOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요 ?");
        int personCount = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        int maxLengthOfLadder = sc.nextInt();

        person = new Person(personCount);
        ladder = new Ladder(maxLengthOfLadder, person);
        output = new Output(ladder);
    }
}
