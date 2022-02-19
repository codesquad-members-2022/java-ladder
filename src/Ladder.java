import java.util.Random;

public class Ladder {
    UserManager userManager;
    Random random = new Random();
    char[][] verticalBundle;
    boolean[][] linkBundle;

    public Ladder(UserManager userManager, int ladderNum) {
        this.userManager = userManager;
        int userNum = this.userManager.allUserNumber;
        verticalBundle = new char[ladderNum][userNum];
        linkBundle = new boolean[ladderNum][userNum];
        for (int i = 0; i < ladderNum; i++) {
            initRoute(userNum, i);
            initHorizonLink(userNum, i);
        }
    }

    private void initRoute(int userNum, int ladderCnt) {
        for (int i = 0; i < userNum; i++) {
            verticalBundle[ladderCnt][i] = '|';
        }
    }

    private void initHorizonLink(int userNum, int ladderCnt) {
        int linkLimitNum = userNum - 1;
        for (int i = 0; i < linkLimitNum; i++) {
            linkBundle[ladderCnt][i] = checkPreRouteLink(ladderCnt, i);
        }
    }

    private boolean checkPreRouteLink(int ladderCnt, int userCnt) {
        if (userCnt < 1) {
            return random.nextBoolean();
        }
        int preUserCnt = userCnt - 1;
        if (linkBundle[ladderCnt][preUserCnt]) {
            return false;
        }
        return random.nextBoolean();
    }

    public void print() {
        String allUserName = userManager.allUserRegister;
        System.out.println(allUserName);
        int userNum = verticalBundle.length;
        for (int i = 0; i < userNum; i++) {
            assembleLadder(i);
        }
    }

    private void assembleLadder(int routeNum) {
        int length = verticalBundle[routeNum].length;
        for (int i = 0; i < length; i++) {
            boolean isLink = linkBundle[routeNum][i];
            String horizon = initHorizon(isLink, 10);
            System.out.print(verticalBundle[routeNum][i] + horizon);
        }
        System.out.println();
    }

    private String initHorizon(boolean isLink, int horizonLength) {
        StringBuilder sb = new StringBuilder();
        char temp = isLink ? '-' : ' ';
        for (int i = 0; i < horizonLength; i++) {
            sb.append(temp);
        }
        return sb.toString();
    }
}
