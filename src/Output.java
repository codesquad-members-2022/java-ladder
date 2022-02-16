public class Output {

    StringBuilder sb = new StringBuilder();

    public void printLadder(char[][] ladder){
        for (int row = 0; row < ladder.length; row++) {
            makeColumn(ladder, row);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private char[][] makeColumn(char[][] ladder, int row){
        for (int column = 0; column < ladder[row].length; column++) {
            sb.append(ladder[row][column]);
        }
        return ladder;
    }

}
