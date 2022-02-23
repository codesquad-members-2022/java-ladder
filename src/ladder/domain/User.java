package ladder.domain;

import java.util.Objects;

public class User {

	private static final int MAX_USER_NAME_LENGTH = 5;
	private static final String BLANK = " ";

	private final String originUserName;
	private String userName;

	public User(String userName) {
		this.originUserName = userName.trim();
	}

	public String getUserName() {
		return setNameLengthToFive(originUserName);
	}

	private String setNameLengthToFive(String originUserName) {
		if (originUserName.length() <= MAX_USER_NAME_LENGTH) {
			return padding(originUserName);
		}
		return reduceName(originUserName);
	}

	private String padding(String originUserName) {
		int totalPadding = MAX_USER_NAME_LENGTH - originUserName.length();
		int leftPadding = totalPadding / 2;
		int rightPadding = totalPadding - leftPadding;
		return BLANK.repeat(leftPadding) + originUserName + BLANK.repeat(rightPadding);
	}

	private String reduceName(String originUserName) {
		return originUserName.substring(0, 3) + "..";
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
		return Objects.equals(originUserName, user.originUserName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(originUserName);
	}
}