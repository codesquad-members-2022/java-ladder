package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	static User user;

	@Test
	@DisplayName("유저 이름 5글자 이상 테스트")
	void testUserNameLengthOverFive() {
		user = new User("jeremy0405[Jerry]");
		assertThat(user.getUserName()).isEqualTo("jer..");
	}

	@Test
	@DisplayName("5글자 이하 유저 이름 패딩 테스트")
	void testUserNamePadding() {
		user = new User("a");
		assertThat(user.getUserName()).isEqualTo("  a  ");
	}

}