package ladder.domain;

public class User {

	private final String userName;

	public User(String userName) {
		this.userName = validateUserName(userName);
	}

	private String validateUserName(String userName) {
		userName = userName.trim();
		if (userName.length() > 5) {
			throw new IllegalArgumentException("5글자 이상의 이름을 입력했습니다!");
		}
		return padding(userName);
	}

	private String padding(String userName) {
		switch (userName.length()) {
			case 1:
				return "  " + userName + "  ";
			case 2:
				return " " + userName + "  ";
			case 3:
				return " " + userName + " ";
			case 4:
				return userName + " ";
			default:
				return userName;
		}
	}

	@Override
	public String toString() {
		return userName;
	}
}
