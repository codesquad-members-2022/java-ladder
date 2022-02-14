public class Ladder {
    private final int ladderWidth;
    private final int ladderHeight;
    private String[][] ladders;


    public Ladder(int n, int m) {
        if (!validateUserInput(n) || !validateLineInput(m)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        ladderWidth = (n * 2) - 1;
        ladderHeight = m;
        ladders = new String[ladderHeight][ladderWidth];
        setLadders();
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < ladderWidth; j++) {
                sb.append(ladders[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void setLadders() {
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < ladderWidth; j += 2) {
                ladders[i][j] = "|";
            }
        }

        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 1; j < ladderWidth; j += 2) {
                ladders[i][j] = ((int)(Math.random() * 2)) == 1 ? "-" : " ";
            }
        }
    }

    private boolean validateUserInput(int userCount) {
        if (userCount < 2) {
            return false;
        }
        return true;
    }

    private boolean validateLineInput(int lineCount) {
        if (lineCount < 1) {
            return false;
        }
        return true;
    }
}
