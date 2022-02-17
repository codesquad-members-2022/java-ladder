import java.util.Arrays;
import java.util.Scanner;

public class InputManager {
    public static final int LIMIT_NAME_LENGTH = 5;

    Scanner sc;

    public InputManager() {
        this.sc = new Scanner(System.in);
    }

    public int inputNumber() {
        return sc.nextInt();
    }

    public String inputString() {
        return sc.next();
    }

    public String[] separateCommasFromString(String words) {
        return words.split(",");
    }

    public void validateNameLength(String[] names) {
        boolean tooLongName = Arrays.stream(names)
                .anyMatch(name -> name.length() > LIMIT_NAME_LENGTH);
        if (tooLongName) {
            throw new IllegalArgumentException("각 플레이어의 이름은 5글자 이하로 설정해야 합니다.");
        }
        return;
    }
}
