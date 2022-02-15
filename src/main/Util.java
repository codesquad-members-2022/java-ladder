package main;

public class Util {
    // referenced by https://vivi-world.tistory.com/27
    public static String[][] string2dDeepCopy(String[][] orig, int row, int col) {
        String[][] result = new String[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(orig[i], 0, result[i],0, col);
        }
        return result;
    }
}
