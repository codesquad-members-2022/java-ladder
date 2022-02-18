package domain.game;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameMapDecoratorImplTest {
    
    LadderGameMapDecoratorImpl decorator = LadderGameMapDecoratorImpl.getInstance();
    
    @Test
    @DisplayName("5글자 이하의 이름은 마스킹처리를 하지 않는다.")
    void cutName_Less() {
        String shortName = "honux";
        String cutName = decorator.cutUserName(shortName);

        assertThat(shortName).isEqualTo(cutName);
    }

    @Test
    @DisplayName("5글자를 넘어가는 이름은 마스킹처리를 한다.")
    void cutNameTest_Over() {
        //given
        String longName = "ttasjwi";

        //when
        String cutName = decorator.cutUserName(longName);
        String expectedResult = "tta..";

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(longName).isNotEqualTo(cutName);
        softAssertions.assertThat(cutName).isEqualTo(expectedResult);
        softAssertions.assertThat(cutName.length()).isEqualTo(5);
        softAssertions.assertAll();
    }
}