package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 게임이가능한Line을생성하는지(){
        boolean result = true;
        final int countOfPerson = 100000;
        //given
        Line tempLine = new Line(countOfPerson);
        ArrayList<Boolean> points = tempLine.getPoints();
        //when
        for(int i = 0; i<countOfPerson - 1; i++){
            if((points.get(i) == true) && (points.get(i+1) == true)){
                result=false;
                break;
            }
        }
        //then
        Assertions.assertTrue(result);
    }

}
