public class Main {

    public static void main(String[] args) {
        LadderMap ladderMap = View.createMap();
        char[][] cloneMap = ladderMap.getCloneMap();
        View.printLadderMap(cloneMap);
    }
}
