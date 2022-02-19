import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    UserManager userManager;
    Random random = new Random();
    List<List<Character>> verticalBundle;
    List<List<Boolean>> linkBundle;

    public Ladder(UserManager userManager, int ladderNum) {
        this.userManager = userManager;
        int userNum = this.userManager.allUserNumber;
        verticalBundle = new ArrayList<>();
        linkBundle = new ArrayList<>();
        for (int i = 0; i < ladderNum; i++) {
            initRoute(userNum);
            initHorizonLink(userNum);
        }
    }

    private <T> List<T> tempListInit(int length, T param) {
        List<T> tempList = new ArrayList<T>();
        for (int i = 0; i < length; i++) {
            tempList.add(param);
        }
        return tempList;
    }

    private void initRoute(int userNum) {
        List<Character> tempList = new ArrayList<>();
        tempList = tempListInit(userNum, '|');
        verticalBundle.add(tempList);
    }

    private void initHorizonLink(int userNum) {
        int linkLimitNum = userNum - 1;
        List<Boolean> tempList = new ArrayList<>();
        for (int i = 0; i < linkLimitNum; i++) {
            tempList.add(checkPreRouteLink(tempList, i));
        }
        linkBundle.add(tempList);
    }

    private Boolean checkPreRouteLink(List<Boolean> tempList, int userCnt) {
        if (userCnt < 1) {
            return random.nextBoolean();
        }
        int preUserCnt = userCnt - 1;
        if (tempList.get(preUserCnt).booleanValue()) {
            return false;
        }
        return random.nextBoolean();
    }

    public void print() {
        String allUserName = userManager.allUserRegister;
        System.out.println(allUserName);
        int userNum = verticalBundle.size();
        for (int i = 0; i < userNum; i++) {
            assembleLadder(i);
        }
    }

    private void assembleLadder(int routeNum) {
        int length = verticalBundle.get(routeNum).size();
        for (int i = 0; i < length; i++) {
            boolean linkLimitCheck = linkBundle.get(routeNum).size() > i;
            boolean isLink = linkLimitCheck ? linkBundle.get(routeNum).get(i) : false;
            String horizon = initHorizon(isLink, 10);
            System.out.print(verticalBundle.get(routeNum).get(i) + horizon);
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
