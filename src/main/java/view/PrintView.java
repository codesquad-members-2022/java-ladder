package view;

public class PrintView {
    public static void requestPeopleNumber() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void requestLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadderWidth(char[] chars) {
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
    }

    public static void showLadder(char[][] ladderBoard) {
        for (char[] chars : ladderBoard) {
            printLadderWidth(chars);
        }
    }

    public static void requestPeopleName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }
}
