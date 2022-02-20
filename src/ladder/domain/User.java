package ladder.domain;

import java.util.Objects;

public class User {

	private static final int MAX_USER_NAME_LENGTH = 5;
	private static final String BLANK = " ";
	private final String userName;

	public User(String userName) {
		this.userName = validateUserName(userName);
	}

	private String validateUserName(String userName) {
		userName = userName.trim();
		return setNameLengthToFive(userName);
	}

	private String setNameLengthToFive(String userName) {
		if (userName.length() <= MAX_USER_NAME_LENGTH) {
			return padding(userName);
		}
		return reduceName(userName);
	}

	private String padding(String userName) {
		int totalPadding = MAX_USER_NAME_LENGTH - userName.length();
		int leftPadding = totalPadding / 2;
		int rightPadding = totalPadding - leftPadding;
		return BLANK.repeat(leftPadding) + userName + BLANK.repeat(rightPadding);
	}

	private String reduceName(String userName) {
		return userName.substring(0, 3) + "..";
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(userName, user.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}
}
