import java.util.Scanner;

public class InputItem {
    int userNum = 0;
    int ladderNum = 0;

    public InputItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        userNum = scanner.nextInt();
        System.out.println(userNum);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderNum = scanner.nextInt();
        System.out.println(ladderNum);
    }

}
