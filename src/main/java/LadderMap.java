import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderMap {
    private List<Ladder> ladderList;
    private List<String> map;
    private int ladderHeight;
    private final static Random random = new Random();

    public LadderMap(List<Ladder> ladderList, int ladderHeight) {
        this.ladderList = ladderList;
        this.ladderHeight = ladderHeight;
        initMap();
    }

    private void initMap() {
        map = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(getBlankString());
            sb.append("|");
            for (int j = 1; j < ladderList.size(); j++) {
                sb.append(getBlankOrLadderString());
                sb.append("|");
            }
        }
    }

    private String getBlankOrLadderString() {
        if (random.nextBoolean()) {
            return getLadderString();
        }
        return getBlankString();
    }

    private String getBlankString() {
        return "     ";
    }

    private String getLadderString() {
        return "-----";
    }
}
