public class Output {

    private void printOneHight(String[] ladderOneHight) {
        for (int i = 0; i < ladderOneHight.length; i++) {
            System.out.print(ladderOneHight[i]);
        }
    }

    public void printLadder(String[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            printOneHight(ladder[i]);
            System.out.println();
        }
    }

}

