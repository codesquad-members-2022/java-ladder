public class Printer {

    public static void outputPlayerPrompt() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void outputHeightPrompt() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void result(String[][] makeLadder) {
        System.out.println();
        for(String[] i : makeLadder){
            printColumnWise(i);
            System.out.println();
        }
    }

    private static void printColumnWise(String[] i) {
        for(String j : i){
            System.out.print(j);
        }
    }
}
