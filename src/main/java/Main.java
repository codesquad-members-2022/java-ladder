import java.util.List;

public class Main {

    public static void main(String[] args) {
        Ladder ladder = View.createLadder();
        List<String> map = ladder.getMap();
        View.printMap(map);
    }
}
