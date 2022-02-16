package main.view;

import java.util.Arrays;

public class OutputView {
    public static final String NUM_OF_ATTENDANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MAXIMUM_HEIGHT_OF_LADDERS = "최대 사다리 높이는 몇 개 인가요?";

    public static void printParticipantsNameQueryText() {
        System.out.println(NUM_OF_ATTENDANTS);
    }
    public static void printMaxHeightOfLadderQueryText() {
        System.out.println(MAXIMUM_HEIGHT_OF_LADDERS);
    }

    public static void printLadderBoard(String[][] ladderBoard) {
        String ans = Arrays.stream(ladderBoard)
          .map(arr -> {
              StringBuilder sb = new StringBuilder();
              sb.append("|").append(String.join("|",arr)).append("|\n");
              return sb.toString();
          })
          .reduce("", String::concat);
        System.out.println(ans);
    }
}
