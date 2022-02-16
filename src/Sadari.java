public class Sadari {
    private boolean[][] sadari;

    Sadari(int userNumber, int sadariNumber) {
        sadari = new boolean[sadariNumber][userNumber - 1];
        generateRandomSadari();
    }

    private void generateRandomSadari() {
        for (int i=0;i< sadari.length;i++){
            sadari[i] = generateRandomLineOfSadari( sadari[i] );
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

    public boolean[][] getSadari () {
        return sadari;
    }

}
