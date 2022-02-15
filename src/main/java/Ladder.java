public class Ladder {

    private static final char USER_LINE= '|';
    private static final char CONNECTION_LINE= '-';
    private static final char EMPTY_SPACE = ' ';
    private char[][] ladders;


    public Ladder(int userCount, int ladderHeight) {
        if (!validateLadderInput(userCount, ladderHeight)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        ladders = new char[ladderHeight][(userCount * 2) - 1];
        setLadders();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] ladder : ladders) {
            sb.append(String.valueOf(ladder).replaceAll(",","") + "\n");
        }
        return sb.toString();
    }

    private void setLadders() {
        for (char[] ladder : ladders) {
            drawLadderRow(ladder);
        }
    }

    private boolean validateLadderInput(int userCount, int lineCount) {
        return userCount >= 2 && lineCount >=1;
    }

    private void drawLadderRow(char[] ladderRow) {
        for (int i = 0; i < ladderRow.length; i++) {
            ladderRow[i] = isUserLine(i);
        }
    }

    private char isUserLine(int n) {
        if (n % 2 == 0) {
            return USER_LINE;
        }
        return ((int)(Math.random() * 2)) == 1 ? CONNECTION_LINE : EMPTY_SPACE;
    }

}
