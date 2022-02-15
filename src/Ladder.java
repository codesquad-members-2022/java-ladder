import java.util.Random;

public class Ladder {
    String[][] bundle;

    public Ladder(int userNum, int ladderNum){
        bundle = new String[ladderNum][userNum];
        for(int i = 0; i < ladderNum; i++){
            for(int j = 0; j < userNum; j++){
                bundle[i][j] = "|";
            }
        }
    }

    public void print(){
        Random random = new Random();
        int userNum = bundle.length;
        for(int i = 0; i < userNum; i++){
            System.out.print("|");
            for(int j = 1; j < bundle[i].length; j++){
                boolean isJoin = random.nextBoolean();
                String horizon = isJoin ? "-" : " ";
                System.out.print(horizon + bundle[i][j]);
            }
            System.out.println();
        }
    }
}
