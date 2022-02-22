package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @DisplayName("유저 이름을 각각 다섯글자,다섯글자,일곱글자,여덟글자끼리 초기화하고 출력할때의 모습 그대로 크기를 비교해보았습니다." +
            "다섯글자를 초과하면 '..'을 뒤에 표시하라고 중간에 요구사항이 변경되어서 일곱글자와 여덟글자 이름을 비교해보았습니다. ")
    @Test
    void processUserName() {
        // given
        User user1 = new User("가나다라마");
        User user2 = new User("바사아자차");
        User user3 = new User("바사아자차김치");
        User user4 = new User("바사아자차깍두기");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        UserManager userManager = new UserManager(userList);

        // when
        String fiveName1 = userManager.processUserName(user1);
        String fiveName2 = userManager.processUserName(user2);
        String sevenName = userManager.processUserName(user1);
        String eightName = userManager.processUserName(user2);

        // then
        Assertions.assertEquals(fiveName1.length(), fiveName2.length());
        Assertions.assertEquals(sevenName.length(), eightName.length());
    }
}