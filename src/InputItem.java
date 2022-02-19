import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputItem {
    Scanner scanner = new Scanner(System.in);

    public List<User> inputUserName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String str = scanner.nextLine();
        String[] userNames = str.split(",");
        List<User> userBundle = new ArrayList<>();
        for (int i = 0; i < userNames.length; i++) {
            userBundle.add(new User(userNames[i]));
        }
        return userBundle;
    }

    public int inputLadderNumber() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
