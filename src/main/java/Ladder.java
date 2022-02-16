import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int USERNAME_MAXLENGTH = 5;
    private static final int USERNAME_MINLENGTH = 1;
    private static final String USER_LINE = "|";
    private static final String CONNECTION_LINE = "-----";
    private static final String EMPTY_SPACE = "     ";
    private final int ladderWidth;
    private final int ladderHeight;
    private List<String> usernames;
    private List<List<String>> ladders;


    public Ladder(List<String> usernames, int ladderHeight) {
        if (!validateUsernameLength(usernames) || !validateLadderHeight(ladderHeight)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        this.ladderWidth = calculateLadderWidth(usernames);
        this.ladderHeight = ladderHeight;
        this.usernames = usernames;
        initLadder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        usernames.forEach(s -> sb.append(s + " "));
        sb.append("\n");

        ladders.forEach(ladder->{
            StringBuilder row = new StringBuilder();
            ladder.forEach(s->row.append(s));
            sb.append(row + "\n");
        });
        return sb.toString();
    }

    private void initLadder() {
        ladders = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladders.add(createLadderRow());
        }
    }

    private List<String> createLadderRow() {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < ladderWidth; i++) {
            row.add(createRowElement(i, row));
        }
        return row;
    }

    private String createRowElement(int n, List<String> row) {
        if (n % 2 == 0) {
            return USER_LINE;
        }
        return createLine(n,row);
    }

    private String createLine(int n, List<String> row) {
        if(n == 1) return createLineByRandom();
        return row.get(n - 2).equals(CONNECTION_LINE) ? EMPTY_SPACE : createLineByRandom();
    }

    private String createLineByRandom() {
        return RandomUtil.getRandomNum(10) >= 4 ? CONNECTION_LINE : EMPTY_SPACE;
    }

    private boolean validateUsernameLength(List<String> usernames) {
        return usernames.stream()
                .allMatch((s) -> (s.length() >= USERNAME_MINLENGTH) && (s.length() <= USERNAME_MAXLENGTH));
    }

    private boolean validateLadderHeight(int lineCount) {
        return lineCount >= 1;
    }

    private int calculateLadderWidth(List<String> usernames) {
        return usernames.size() * 2 - 1;
    }

}
