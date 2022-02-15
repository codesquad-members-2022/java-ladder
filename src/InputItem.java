import java.util.Scanner;

public class InputItem {
    Scanner scanner = new Scanner(System.in);

    public int inputUserNumber(){
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }
    public int inputLadderNumber(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
