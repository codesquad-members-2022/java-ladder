package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ladder.domain.User;

public class Input {

	private static final Scanner sc = new Scanner(System.in);

	private Input() {}

	public static int getLadderHeight(String message) {
		return getIntInput(message);
	}

	private static int getIntInput(String message) {
		System.out.println(message);
		int intInput = sc.nextInt();
		sc.nextLine();
		return intInput;
	}

	public static List<User> getUserName() {
		System.out.println("참여할 사람 이름을 입력하세요.");
		String[] userNames = getStringArrBySplitComma();
		return stringArrToList(userNames);
	}

	private static List<User> stringArrToList(String[] userNames) {
		List<User> userList = new ArrayList<>();
		Arrays.stream(userNames).forEach(name -> userList.add(new User(name)));
		return userList;
	}

	public static List<String> getUserResult() {
		System.out.println("실행 결과를 입력하세요.");
		String[] userResult = getStringArrBySplitComma();
		return List.of(userResult);
	}

	private static String[] getStringArrBySplitComma() {
		return sc.nextLine().split(",");
	}

	public static void close() {
		sc.close();
	}

}
