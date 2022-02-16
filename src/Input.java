import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		String[] userNames = sc.nextLine().split(",");
		List<User> userList = new ArrayList<>();
		for (String user : userNames) {
			try {
				userList.add(new User(user));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return getUserName();
			}
		}
		return userList;
	}


	public static void close() {
		sc.close();
	}

}
