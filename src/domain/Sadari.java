package domain;

import java.util.*;

public class Sadari {
    private List<Line> sadari;

    public Sadari(int userNumber, int sadariNumber) {
        sadari = new ArrayList<Line>();
        for(int i=0;i<sadariNumber;i++){
            Line temp= new Line(userNumber -1);
            System.out.println( temp.toString() );
            sadari.add( temp );
        }
    }

}
