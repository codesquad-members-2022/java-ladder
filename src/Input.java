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

	public static List<String> getUserName() {
		System.out.println("참여할 사람 이름을 입력하세요.");
		String userNameWithComma = sc.nextLine();
		List<String> userNames = Arrays.stream(userNameWithComma.split(",")).collect(Collectors.toList());
		return validateUserName(userNames);
	}

	private static List<String> validateUserName(List<String> userNames) {
		//todo 사람 이름 5글자 이하 확인
		return userNames;
	}

	public static void close() {
		sc.close();
	}

}
