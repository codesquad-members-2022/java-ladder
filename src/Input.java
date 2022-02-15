import java.util.Scanner;

public class Input {

	private static final Scanner sc = new Scanner(System.in);

	private Input() {}

	public static int[] getUserInput() {
		int[] userInput = new int[2];
		System.out.println("참여할 사람은 몇 명인가요?");
		userInput[0] = sc.nextInt();
		sc.nextLine();

		System.out.println("최대 사다리 높이는 몇 개인가요?");
		userInput[1] = sc.nextInt();
		sc.nextLine();

		return userInput;
	}

	public static void close() {
		sc.close();
	}

}
