public class Output {
    public void printLadder(char[][] resultLadder) {
        for (char[] line : resultLadder) {
            for (char lineOfCh : line) {
                System.out.print(lineOfCh);
            }
            System.out.println();
        }
    }
}
