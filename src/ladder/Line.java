package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        int limitRouteSize = countOfPerson - 1;
        for(int i = 0; i < limitRouteSize; i++){
            points.add(checkHorizonPoint(points, i));
        }
    }

    public ArrayList<Boolean> getPoints(){
        return points;
    }

    private Boolean checkHorizonPoint(List<Boolean> tempList, int userCnt){
        Random random = new Random();
        if (userCnt < 1) {
            return random.nextBoolean();
        }
        int preUserCnt = userCnt - 1;
        if (tempList.get(preUserCnt)) {
            return false;
        }
        return random.nextBoolean();
    }

    // TODO reserve
    private <T> ArrayList<T> tempListInit(int length, T param) {
        ArrayList<T> tempList = new ArrayList<T>();
        for (int i = 0; i < length; i++) {
            tempList.add(param);
        }
        return tempList;
    }
}
