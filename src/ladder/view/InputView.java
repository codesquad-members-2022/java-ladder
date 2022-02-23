package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner sc = new Scanner(System.in);

	private InputView() {}

	public static int getLadderHeight(String message) {
		return getIntInput(message);
	}

	private static int getIntInput(String message) {
		System.out.println(message);
		int intInput = sc.nextInt();
		sc.nextLine();
		return intInput;
	}

	public static List<String> getUserCommand(String message) {
		System.out.println(message);
		String[] userResult = getStringArrBySplitComma();
		return List.of(userResult);
	}

	private static String[] getStringArrBySplitComma() {
		return sc.nextLine().split(",");
	}

	public static String getUserName() {
		System.out.println("결과를 보고 싶은 사람은?");
		return sc.nextLine();
	}

	public static void close() {
		sc.close();
	}

}
