public class OutputLadder {

    public void printRules(String str){
        System.out.println(str);
    }

    public void printLadder(char[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++) {
                System.out.println(ladder[i][j]);
            }
            System.out.println();
        }
    }

}
