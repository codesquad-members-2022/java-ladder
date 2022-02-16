import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        LadderMap ladderMap = View.createMap();
        List<String> map = ladderMap.getMap();
        View.printMap(map);
    }
}
