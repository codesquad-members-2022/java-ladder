public class OutputView {
    private static final String userNumberMessage = "참여할 사람은 몇 명인가요?";
    private static final String sadariNumberMessage = "최대 사다리 높이는 몇 개인가요?";
    private static final char sero = '|';
    private static final char garo = '-';
    private static final char empty = ' ';

    public static void printUserNumberMessage(){

        System.out.println(userNumberMessage);
    }

    public static void printSadariNumberMessage(){

        System.out.println(sadariNumberMessage);
    }

    public static void printGraphicalSadari(boolean[][] sadari){
        for(int i = 0; i < sadari.length; i++){
            StringBuilder line = new StringBuilder();
            line.append( sero );
            for(int j = 0; j < sadari[0].length; j++){
                line.append( sadari[i][j]==false ? empty : garo );
                line.append( sero );
            }
            System.out.println( line );
        }
    }


}
