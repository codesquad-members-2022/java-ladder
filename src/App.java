import java.util.Random;
import java.util.Scanner;

public class App {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // n명의 사람의 수를 입력할 수 있어야 한다.
        int playerCount = inputRules("참여할 사람은 몇 명인가요?");

        // m개의 사다리 개수를 입력할 수 있어야 한다.
        int ladderHeight = inputRules("최대 사다리 높이는 몇 개인가요?");

        // 배열의 첫번째 값에는 사다리의 높이, 두번째 값에는 사람 수를 넣는다.
        String[][] ladder = new String[ladderHeight][(playerCount*2) -1];

        Random random = new Random();

        // 사다리 생성
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++) {
                // 2차원 배열 행의 순서가 0과 짝 일때는 | 를, 홀수일때는 -를 넣는다.
                if(j == 0 ||j % 2 == 0) {
                    ladder[i][j] = "|";
                // 랜덤으로 불리언값을 가져와 짝대기를 넣어준다.
                }else if(random.nextBoolean()) {
                    ladder[i][j] = "-";
                }else {
                    ladder[i][j] = " ";
                }
            }
        }

        // 출력
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }

    }

    // 입력
    private static int inputRules(String x) {
        System.out.println(x);
        return sc.nextInt();
    }


}
