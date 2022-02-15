public class Printer {

    public static void outputPlayerPrompt() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void outputHeightPrompt() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printResult(char[][] makeLadder) {
        System.out.println();
        for(char[] i : makeLadder){
            printColumnWise(i);
            System.out.println();
        }
    }

    private static void printColumnWise(char[] i) {
        for(char j : i){
            System.out.print(j);
        }
    }
}
