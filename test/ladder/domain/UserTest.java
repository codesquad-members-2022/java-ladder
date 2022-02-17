package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	static User user;

	@Test
	@DisplayName("유저 이름 5글자 이상 테스트")
	void test1() {
		user = new User("jeremy0405[Jerry]");
		assertEquals("jer..", user.toString());
	}

	@Test
	@DisplayName("유저 이름 \"\" 테스트")
	void test2() {
		user = new User("");
		assertEquals("     ", user.toString());
	}

	@Test
	@DisplayName("유저 이름 패딩 테스트")
	void test3() {
		user = new User("a");
		assertEquals("  a  ", user.toString());
	}

}