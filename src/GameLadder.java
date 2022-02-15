import java.util.Random;
import java.util.Scanner;

public class GameLadder {
    public int[] gameInfo() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int numOfPeople = inputNumber();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = inputNumber();

        return new int[]{numOfPeople, heightOfLadder};
    }

    public void start(int[] gameInfo) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< gameInfo[1]; i++) {
            for(int j=0; j< gameInfo[0]; j++){
                sb.append("|");
                if(j==gameInfo[0]-1){
                    break;
                }
                sb.append(makeLadderLine());
            }
            sb.append(System.lineSeparator());
        }
        print(sb);
    }

    private void print(StringBuilder stringBuilder) {
        System.out.println(stringBuilder);
    }

    private String makeLadderLine() {
        boolean isLineExist =  isExist(randomNumber());
        if(isLineExist) {
            return "-";
        }
        return " ";
    }

    private int randomNumber(){
        Random random =  new Random();
        return random.nextInt(2);
    }


    private boolean isExist(int number) {
        if(number == 0) {
            return false;
        }
        return true;
    }

    private int inputNumber() {
        return new Scanner(System.in).nextInt();
    }
}
