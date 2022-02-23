import View.OutputView;
import com.sun.jdi.Value;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OutputViewTest {

    @ParameterizedTest
    @DisplayName("출력시 이름을 수정")
    @CsvSource(value = {"honuxJJang:' hon..'", "honux:' honux'", "h:'     h'", "ho:'    ho'", "hon:'   hon'", "honu:'  honu'"}, delimiter = ':')
    void editLengthTestName(String input, String expected) {
        //editLength(String value)
        Assertions.assertThat(OutputView.editLength(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("출력시 결과값을 수정")
    @CsvSource(value = {"1등:'    1등'", "꽝:'     꽝'", "수고하셨습니다:' 수고하..'", "안녕하:'   안녕하'", "안녕하세:'  안녕하세'", "안녕하세요:' 안녕하세요'"}, delimiter = ':')
    void editLengthTestResult(String input, String expected) {
        //editLength(String value)
        Assertions.assertThat(OutputView.editLength(input)).isEqualTo(expected);
    }
}
