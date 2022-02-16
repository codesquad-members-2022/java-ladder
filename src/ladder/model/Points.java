package ladder.model;

import ladder.model.ladder.Point;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private static final List<Point> points = new ArrayList<>();

    static {
        for(int index= 0; index<50; index++){
            points.add(new Point(index, new Direction(false, false)));
            points.add(new Point(index, new Direction(false, true)));
            points.add(new Point(index, new Direction(true, false)));
            points.add(new Point(index, new Direction(true, true)));
        }
    }
    public static Point of(){
        return null;
    }


}
