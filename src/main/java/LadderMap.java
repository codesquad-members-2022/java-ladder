public class LadderMap {
    private char[][] map;
    private int personCount;
    private int ladderHeight;

    public LadderMap(int personCount, int ladderHeight) {
        if (personCount < 0 || ladderHeight < 0) {
            throw new IllegalArgumentException("매개변수는 0 이상이어야 합니다.");
        }
        this.personCount = personCount;
        this.ladderHeight = ladderHeight;
        map = new char[ladderHeight][personCount * 2 - 1];
    }

}
