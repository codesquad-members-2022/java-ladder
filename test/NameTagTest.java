import domain.NameTag;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTagTest {

    @Test
    void When_n글자문자열_Expect_양끝에공백을추가하여NAME_TAG_SIZE길이로포장된문자열() {
        NameTag oneLengthNameTag = new NameTag("a");
        assertEquals(oneLengthNameTag.getNameTag().length(), NameTag.NAME_TAG_SIZE);
        assertEquals(oneLengthNameTag.getNameTag(), "   a   ");

        NameTag twoLengthNameTag = new NameTag("ab");
        assertEquals(twoLengthNameTag.getNameTag().length(), NameTag.NAME_TAG_SIZE);
        assertEquals(twoLengthNameTag.getNameTag(), "  ab   ");

        NameTag threeLengthNameTag = new NameTag("abc");
        assertEquals(threeLengthNameTag.getNameTag().length(), NameTag.NAME_TAG_SIZE);
        assertEquals(threeLengthNameTag.getNameTag(), "  abc  ");

        NameTag fourLengthNameTag = new NameTag("abcd");
        assertEquals(fourLengthNameTag.getNameTag().length(), NameTag.NAME_TAG_SIZE);
        assertEquals(fourLengthNameTag.getNameTag(), " abcd  ");

        NameTag fiveLengthNameTag = new NameTag("abcde");
        assertEquals(fiveLengthNameTag.getNameTag().length(), NameTag.NAME_TAG_SIZE);
        assertEquals(fiveLengthNameTag.getNameTag(), " abcde ");
    }

    @Test
    @Disabled
    void When_추가해야할공백이짝수개_Expect_오른쪽공백이왼쪽공백보다1개많게포장된문자열() {
        // 현재 전역변수 LIMIT_NAME_LENGTH = 5, LEFT_PADDING_SIZE = 1, RiGHT_PADDING_SIZE = 1 로 설정되어 있고,
        // NAME_TAG_SIZE = LIMIT_NAME_LENGTH + LEFT_PADDING_SIZE + LEFT_PADDING_SIZE 로 설정된 상태.

        NameTag oneLengthNameTag = new NameTag("a"); // 추가할 이름이 홀수개 일 때
        assertEquals(oneLengthNameTag.getNameTag(), "   a   "); // NAME_TAG_SIZE = 7
        assertEquals(oneLengthNameTag.getNameTag(), "    a    "); // NAME_TAG_SIZE = 9
        assertEquals(oneLengthNameTag.getNameTag(), "   a    "); // NAME_TAG_SIZE = 8 짝수개 일 때 오른쪽 패딩이 1개 더 많음

        NameTag twoLengthNameTag = new NameTag("ab"); // 추가할 이름이 짝수개 일 때
        assertEquals(oneLengthNameTag.getNameTag(), "  ab   "); // NAME_TAG_SIZE = 7 홀수개 일 때 오른쪽 패딩이 1개 더 많음
        assertEquals(oneLengthNameTag.getNameTag(), "   ab    "); // NAME_TAG_SIZE = 9 홀수개 일 때 오른쪽 패딩이 1개 더 많음
        assertEquals(oneLengthNameTag.getNameTag(), "   ab   "); // NAME_TAG_SIZE = 8
    }
}
