import java.util.Random;

public class Ladder {
    char[][] bundle;

    public Ladder(int userNum, int ladderNum) {
        bundle = new char[ladderNum][userNum];
        for (int ladderCnt = 0; ladderCnt < ladderNum; ladderCnt++) {
            initRoute(userNum, ladderCnt);
        }
    }

    private void initRoute(int userNum, int ladderCnt) {
        for (int i = 0; i < userNum; i++) {
            bundle[ladderCnt][i] = '|';
        }
    }

    public void print() {
        int userNum = bundle.length;
        for (int i = 0; i < userNum; i++) {
            buildHorizon(i);
        }
    }

    private void buildHorizon(int routeNum) {
        Random random = new Random();
        int length = bundle[routeNum].length;
        for (int i = 0; i < length; i++) {
            boolean isJoin = i + 1 == length ? false : random.nextBoolean();
            String horizon = isJoin ? "-" : " ";
            System.out.print(bundle[routeNum][i] + horizon);
        }
        System.out.println();
    }
}
