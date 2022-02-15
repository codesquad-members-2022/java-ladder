import java.util.Random;

public class PrintItem {

    public void printLadder(int userNum, int ladderNum){
        Random random = new Random();
        for(int i = 0; i < ladderNum; i++){
            System.out.print("|");
            for(int j = 1; j < userNum; j++){
                boolean isJoin = j == userNum ? true : random.nextBoolean();
                String tile = isJoin ? " |" : "-|";
                System.out.print(tile);
            }
            System.out.println();
        }
    }
}
