package step0.view;

public class OutputView {
    public static void showLadder(char[][] ladder) {
        int height = ladder.length;
        int width = ladder[1].length;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}
