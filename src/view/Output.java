package view;

import domain.Formatter;
import domain.Ladder;
import domain.Line;

import java.util.List;

public class Output {
    private static final int WIDTH = 5;

    public static void messageAboutLadder(Ladder ladder) {
        System.out.println("사다리 결과\n");
        List<Line> ladderInfo = ladder.getLadderInfo();
        List<String> playersInfo = ladder.getPlayersInfo();
        List<String> resultsInfo = ladder.getResultsInfo();

        System.out.println(ladderGameInfo(ladderInfo, playersInfo, resultsInfo));
    }

    public static void messageAboutGame(String gameResult) {
        if (gameResult.equals("춘식이")) {
            System.out.println("게임을 종료합니다.");
            return;
        }
        System.out.println("실행 결과");
        System.out.println(gameResult);
    }

    private static String ladderGameInfo(List<Line> ladderInfo, List<String> playersInfo, List<String> resultsInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(putPlayers(playersInfo));
        for (int i = 0; i < ladderInfo.size(); i++) {
            sb.append(rowOfLadderInfo(ladderInfo, playersInfo, i));
        }
        sb.append(putResults(resultsInfo));
        return sb.toString();
    }

    private static String rowOfLadderInfo(List<Line> ladderInfo, List<String> playersInfo, int index) {
        StringBuilder sb = new StringBuilder();
        String expandedRow;
        sb.append("  |");
        for (int i = 0; i < playersInfo.size() - 1; i++) {
            expandedRow = expandRowWidth(ladderInfo.get(index).get(i));
            sb.append(expandedRow);
            sb.append("|");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static String expandRowWidth(boolean element) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            sb.append(transValue(element));
        }
        return sb.toString();
    }

    private static char transValue(boolean element) {
        if (element) {
            return '-';
        }
        return ' ';
    }

    private static String putPlayers(List<String> playersInfo) {
        StringBuilder sb = new StringBuilder();
        for (String player : playersInfo) {
            sb.append(Formatter.checkAndPadding(player, WIDTH));
            sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static String putResults(List<String> resultsInfo) {
        StringBuilder sb = new StringBuilder();
        for (String result : resultsInfo) {
            sb.append(Formatter.checkAndPadding(result, WIDTH));
            sb.append(" ");
        }
        return sb.toString();
    }
}
