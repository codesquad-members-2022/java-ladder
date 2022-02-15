public class Output {

    public static void printLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}
