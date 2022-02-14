import java.util.Scanner;

public class Main {

    public static int randomNumber() {
        return (int) (Math.random() * 2);
    }

    public static String line(int people, int number) {
        String[] line = {"-", " "};
        if (number < people - 1) {
            return line[randomNumber()];
        }
        return " ";
    }

    public static String[] ladderOneHight(int people) {
        String[] ladderLine = new String[people * 2];
        String pole = "|";
        for (int i = 0; i < people * 2; i = i + 2) {
            ladderLine[i] = pole;
            ladderLine[i + 1] = line(people, i / 2);
        }
        return ladderLine;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int people = scan.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHight = scan.nextInt();
        System.out.println();

        String[][] ladder = new String[people * 2][ladderHight];
        for (int i = 0; i < ladderHight; i++) {
            ladder[i] = ladderOneHight(people);
        }

        for (int i = 0; i < ladderHight; i++) {
            for (int j = 0; j < people * 2; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }


    }
}
