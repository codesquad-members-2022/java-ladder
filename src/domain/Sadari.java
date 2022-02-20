package domain;

import java.util.*;

public class Sadari {
    private List<Line> sadari;

    public Sadari(int userNumber, int sadariNumber) {
        sadari = new ArrayList<Line>();
        for(int i=0;i<sadariNumber;i++){
            sadari.add( new Line(userNumber -1) );
        }
    }

    public List<Line> getSadari() {
        return sadari;
    }
}
