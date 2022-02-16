import java.util.Scanner;

public class Input {
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
    }

    private int validateValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("값을 잘못입력하셨습니다.");
            return -1;
        }
    }

    private void askNumberOfPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        String value = scanner.nextLine();
        int parseInt = validateValue(value);
        Number number = new Number(parseInt);
        people = number.getNumber();
    }

    private void askHight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String value = scanner.nextLine();
        int parseInt = validateValue(value);
        Number number = new Number(parseInt);
        hight = number.getNumber();
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
