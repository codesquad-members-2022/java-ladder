package main.view;

import java.util.List;
import main.util.nameFormatter;

public class OutputView {
    public static final String NUM_OF_ATTENDANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MAXIMUM_HEIGHT_OF_LADDERS = "최대 사다리 높이는 몇 개 인가요?";

    public static void printParticipantsNameQueryText() {
        System.out.println(NUM_OF_ATTENDANTS);
    }
    public static void printMaxHeightOfLadderQueryText() {
        System.out.println(MAXIMUM_HEIGHT_OF_LADDERS);
    }

    public static void printLadderBoard(String names, List<List<String>> ladderBoard) {
        StringBuilder sb = new StringBuilder();
        getNamesRow(names,sb);
        getLaddersRow(ladderBoard,sb);
        System.out.println(sb.toString());
    }

    public static void getNamesRow(String names, StringBuilder sb) {
        String[] nameList = names.split(",");
        for (String name: nameList) {
            sb.append(" ").append(nameFormatter.blankPadding(name));
        }
        sb.append("\n");
    }

    public static void getLaddersRow(List<List<String>> ladderBoard, StringBuilder sb) {
        for (List<String> row : ladderBoard) {
            getLaddersCol(row,sb);
        }
    }

    public static void getLaddersCol(List<String> ladderBoard, StringBuilder sb) {
        sb.append("   ");
        for (String sign : ladderBoard) {
            sb.append("|").append(sign);
        }
        sb.append("|\n");
    }
}
