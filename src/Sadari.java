public class Sadari {
    private boolean[][] sadari;

    Sadari(int userNumber, int sadariNumber) {
        sadari = new boolean[sadariNumber][userNumber - 1];
        generateRandomSadari();
    }

    //https://coozplz.me/2011/11/09/2%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4for%EB%AC%B8-%ED%95%98%EB%82%98%EB%A1%9C-%EC%B6%9C%EB%A0%A5/
    private void generateRandomSadari() {
        for (int i = 0; i < sadari.length * sadari[0].length; i++) {
            sadari[i / sadari[0].length][i % sadari[0].length] = getRandomBoolean();
            i += sadari[i / sadari[0].length][i % sadari[0].length] == true ? 1 : 0 ;
        }
    }

    private boolean getRandomBoolean () {
        return Math.random() > 0.5 ? false : true;
    }



    public boolean[][] getSadari () {
        return sadari;
    }


}
