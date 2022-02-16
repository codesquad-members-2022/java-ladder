package domain;

public class LadderSize {
    private int height;
    private int numOfPerson;

    private LadderSize(int height, int numOfPerson) {
        this.height = height;
        this.numOfPerson = numOfPerson;
    }

    public static LadderSize create(int height, int numOfPerson) {
        return new LadderSize(height, numOfPerson);
    }

    public int[] convertPositionToXY(int position) {
        int[] ints = new int[2];
        ints[0] = position / numOfPerson; // x좌표
        ints[1] = position % numOfPerson; // y좌표
        return ints;
    }
    public int getCountOfLine(double ratio) {
        int totalPositions = getTotalPositions();
        return (int)(totalPositions * ratio);
    }

    public int getTotalPositions() {
        return height * numOfPerson;
    }

    public int getHeight() {
        return height;
    }

    public int getNumOfPerson() {
        return numOfPerson;
    }
}
