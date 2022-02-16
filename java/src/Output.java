public class Output {

    private void printOneHight(char[] ladderOneHight) {
        for (int i = 0; i < ladderOneHight.length; i++) {
            System.out.print(ladderOneHight[i]);
        }
    }

    public void printLadder(Ladder ladder) {
        char[][] frame = ladder.getLadder();
        for (int i = 0; i < frame.length; i++) {
            printOneHight(frame[i]);
            System.out.println();
        }
    }

}

