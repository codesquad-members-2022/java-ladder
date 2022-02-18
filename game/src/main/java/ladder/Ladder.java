package ladder;

import game.GameRepository;

import java.util.List;
import java.util.Random;

public class Ladder {

    private static GameRepository gameRepository = GameRepository.getInstance();
    private static String row = "---------";
    private static String emptyRow = "         ";
    private static String column = "|";
    private int preNumber = -1;

    public String makeNameString() {
        StringBuilder sb = new StringBuilder();
        List<String> playerNames = gameRepository.findPlayerNames();
        for (int i = 0; i < playerNames.size(); i++) {
            sb.append(playerNames.get(i)).append("     ");
        }
        return sb.toString();
    }
    public String makeLadder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gameRepository.findHeight(); i++) {
            sb = makeLadderLine(sb).append('\n');
        }
        return sb.toString();
    }

    private StringBuilder makeLadderLine(StringBuilder sb) {
        for (int j = 0; j < gameRepository.findPlayerNumber(); j++) {
            sb = getLine(sb, j);
        }
        return sb;
    }

    private StringBuilder getLine(StringBuilder sb, int j) {
        if (j == getLineNumber()) {
            return sb.append(column);
        }
        return emptyOrFull(sb);
    }

    private StringBuilder emptyOrFull(StringBuilder sb) {
        int number = getRandomNumber();
        if (isEmpty(number)){
            this.preNumber = 0;
            return sb.append(column).append(emptyRow);
        }
        if (isFull(number)) {
            this.preNumber = 1;
            return sb.append(column).append(row);
        }
        return sb;
    }

    private boolean isFull(int number) {
        return number == 1;
    }

    private boolean isEmpty(int number) {
        return preNumber == 1 || number == 0;
    }

    private int getLineNumber() {
        return gameRepository.findPlayerNumber() - 1;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(2);
    }
}
