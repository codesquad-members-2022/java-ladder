import java.util.Arrays;

public class Ladder {

    private static final char COLUMN = '|';
    private static final char ROW = '-';
    private static final char BLACK = ' ';
    private final LadderData ladderData;
    private final UserData userData;
    private char[][] ladderMap;

    // Ladder 객체에 ladderData, userData 가 필요하기 때문에 외부에서 주입받는다.
    // GameController 객체에서 run() 메서드 실행될 때 Ladder 생성자를 호출하게 된다.
    Ladder(LadderData ladderData, UserData userData) {
        this.ladderData = ladderData;
        this.userData = userData;
    }

    // TODO 사다리 정보를 설정하는 메서드
    public void initLadder() {
        int ladderLength = ladderData.getLadderLength();
        int userCount = (userData.getUserCount() * 2) - 1;

        ladderMap = new char[ladderLength][userCount];

        setLadderFrame();
        setLadderFoothold();
    }

    // TODO 설정된 2차원 배열에서 사다리 프레임을 배치하는 메서드
    private void setLadderFrame() {
        for (char[] frame : ladderMap) {
            Arrays.fill(frame, COLUMN);
        }
    }

    // TODO 설정된 2차원 배열에서 랜덤으로 사다리 라인을 배치하는 메서드
    private void setLadderFoothold() {
        for (char[] lines : ladderMap) {
            drawLadderFoothold(lines);
        }
    }

    // TODO 홀 수 인덱스일 때 LadderLine 이 생성될 수 있다.
    private void drawLadderFoothold(char[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = createRandomFoothold(i);
        }
    }

    // TODO char[] line 마다 홀 수 인덱스에 랜덤하게 foothold 가 생성되도록 해야 한다.
    private char createRandomFoothold(int i) {
        if (i % 2 != 0) {
            return ((int)(Math.random() * 2)) == 1 ? ROW : BLACK;
        }

        return COLUMN;
    }

    public char[][] getLadderMap() {
        return ladderMap;
    }
}
