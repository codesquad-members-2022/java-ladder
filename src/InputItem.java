import java.util.ArrayList;
import java.util.Scanner;

public class InputItem {
    Scanner scanner = new Scanner(System.in);

    // 아마 삭제 예정
    public int inputUserNumber() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public ArrayList<User> inputUserName() {
        String str = scanner.nextLine();
        String[] userNames = str.split(",");

        ArrayList<User> userBundle = new ArrayList<>();
        for (int i = 0; i < userNames.length; i++) {
            User newUser = new User(userNames[i]);
            userBundle.add(newUser);
        }
        return userBundle;
    }

    public int inputLadderNumber() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
