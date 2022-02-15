package main.view;

import java.util.Arrays;

public class OutputView {
    public static void printNumOfPeopleQueryText() {
        System.out.println(QueryText.NUM_OF_ATTENDANTS.getText());
    }
    public static void printMaxHeightOfLadderQueryText() {
        System.out.println(QueryText.MAXIMUM_HEIGHT_OF_LADDERS.getText());
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
