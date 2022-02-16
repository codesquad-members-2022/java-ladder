import java.util.Scanner;

public class Input {

    private static final String VALUE_ERROR_MESSAGE = "값을 잘못입력하셨습니다.";
    private static final String ASK_NUMBER_OF_PEOPLE = "참여할 사람은 몇 명인가요?";
    private static final String ASK_LADDER_HIGHT = "최대 사다리 높이는 몇 개인가요?";
    private Scanner scanner;
    private int people;
    private int hight;

    public Input() {
        scanner = new Scanner(System.in);
        start();
    }

    private void start() {
        askNumberOfPeople();
        askHight();
        scanner.close();
    }

    private int validateValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println(VALUE_ERROR_MESSAGE);
            return -1;
        }
    }

    private void askNumberOfPeople() {
        System.out.println(ASK_NUMBER_OF_PEOPLE);
        String value = scanner.nextLine();
        int parseInt = validateValue(value);
        Number number = new Number(parseInt);
        people = number.get();
    }

    private void askHight() {
        System.out.println(ASK_LADDER_HIGHT);
        String value = scanner.nextLine();
        int parseInt = validateValue(value);
        Number number = new Number(parseInt);
        hight = number.get();
    }

    private int checkZero(int value) {
        if (people == 0 || hight == 0) {
            return 0;
        }
        return value;
    }

    public int getPeople() {
        return checkZero(people);
    }

    public int getHight() {
        return checkZero(hight);
    }
}
