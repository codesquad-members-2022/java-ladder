import java.util.Scanner;

public class Input {

	private static final Scanner sc = new Scanner(System.in);

	private Input() {}

	public static int[] getUserInput() {
		int[] userInput = new int[2];
		userInput[0] = getIntInput("참여할 사람은 몇 명인가요?");
		userInput[1] = getIntInput("최대 사다리 높이는 몇 개인가요?");
		return userInput;
	}

	private static int getIntInput(String message) {
		System.out.println(message);
		int intInput = sc.nextInt();
		sc.nextLine();
		return intInput;
	}

	public static void close() {
		sc.close();
	}

}
