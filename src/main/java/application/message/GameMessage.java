package application.message;

import static application.validator.InputValidator.MAX_NAME_LENGTH;

public class GameMessage {
    public static final String REQUEST_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String LENGTH_EXCEEDED_ERR_MESSAGE = String.format("플레이어 명은 %d글자를 초과할 수 없습니다.", MAX_NAME_LENGTH);
    public static final String RUNTIME_ERROR_MESSAGE = "게임 실행 중 에러가 발생했습니다.";
}
