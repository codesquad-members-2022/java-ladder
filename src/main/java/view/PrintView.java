package view;

import java.util.List;

import domain.LadderRow;

public class PrintView {

    public static void printPeopleName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void showLadder(List<String> peoples, List<LadderRow> ladderBoard) {
        namePrinter(peoples);
        ladderPrinter(ladderBoard);
    }

    private static void namePrinter(List<String> peoples) {
        peoples.stream()
            .map(PrintView::formattingName)
            .forEach(System.out::print);
        System.out.println();
    }

    private static String formattingName(String s) {
        if (s.length() == 1) {
            s = "  " + s + "   ";
            return s;
        }
        if (s.length() == 2) {
            s = "  " + s + "  ";
            return s;
        }
        if (s.length() == 3) {
            s = " " + s + "  ";
            return s;
        }
        if (s.length() == 4) {
            s = s + "  ";
            return s;
        }
        s = s + " ";
        return s;
    }

    private static void ladderPrinter(List<LadderRow> ladderBoard) {
        for (LadderRow ladderRow : ladderBoard) {
            ladderRow.getRow().forEach(System.out::print);
            System.out.println();
        }
    }
}
