package ladder;

import ladder.domain.LadderGameManager;

public class Application {
    public static void main(String[] args) {
        // 사다리 게임 어플리케이션 실행부
        LadderGameManager manager = new LadderGameManager();
        manager.init();
    }
}
