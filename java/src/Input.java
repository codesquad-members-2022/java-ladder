import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        Scanner scan = new Scanner(System.in);
        scanner = scan;
    }

    public int getPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int input = scanner.nextInt();
        Number number = new Number(input);
        return number.getNumber();
    }

    public int getHight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = scanner.nextInt();
        Number number = new Number(input);
        return number.getNumber();
    }
}
