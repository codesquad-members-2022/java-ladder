public class Output {


    public void printLadder(char[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}
