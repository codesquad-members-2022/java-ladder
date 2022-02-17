package domain;

import java.util.ArrayList;

public class Sadari {
    private ArrayList<boolean[]> sadari;

    public Sadari(int userNumber, int sadariNumber) {
        //sadari = new boolean[sadariNumber][userNumber - 1];
        sadari = new ArrayList<boolean[]>();
        for(int i=0;i<sadariNumber;i++){
            sadari.add(new boolean[userNumber - 1]);
        }
        generateRandomSadari();
    }

    private void generateRandomSadari() {
        for (int i = 0; i < sadari.size(); i++){
            //sadari[i] = generateRandomLineOfSadari( sadari[i] );
            sadari.set(i, generateRandomLineOfSadari( sadari.get(i) ));
        }
    }

    private boolean[] generateRandomLineOfSadari(boolean[] line){
        for(int i=0;i<line.length;i++){
            line[i] = getRandomBoolean();
            i+=isContinuousGaro(line[i]);
        }
        return line;
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

    public ArrayList<boolean[]> getSadari () {
        return sadari;
    }

}
