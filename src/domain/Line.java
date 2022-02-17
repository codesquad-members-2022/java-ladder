package domain;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson){
        for(int i = 0; i < countOfPerson; i++){
            points.add( false );
        }
        generateRandomLine(countOfPerson);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    private void generateRandomLine(int lineLength){
        for(int i = 0; i < lineLength; i++){
            points.set( i, getRandomBoolean() );
            i += isContinuousGaro( points.get(i) );
        }
    }

    // 가로가 연속해서 존재하지 않게 i값을 조정하는 메소드.
    private int isContinuousGaro(boolean i){
        if(i==true){
            return 1;
        }
        return 0;
    }

    private boolean getRandomBoolean () {

        return Math.random() > 0.5 ? false : true;
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
