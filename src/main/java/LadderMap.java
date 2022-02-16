import java.util.*;

public class LadderMap {
    private List<Ladder> ladderList;
    private List<String> map = new ArrayList<>();;
    private int ladderHeight;
    private final static Random random = new Random();

    public LadderMap(List<Ladder> ladderList, int ladderHeight) {
        this.ladderList = ladderList;
        this.ladderHeight = ladderHeight;
        initMap();
    }

    private void initMap() {
        addMapFirstLine();
        for (int i = 0; i < ladderHeight; i++) {
            addMapLine();
        }
    }

    private void addMapFirstLine() {
        StringBuilder sb = new StringBuilder();
        int size = ladderList.size();
        sb.append("  ");
        for (int i = 0; i < size; i++) {
            String name = ladderList.get(i).getName();
            sb.append(String.format("%5s", name) + " ");
        }
        map.add(sb.toString());
    }

    private void addMapLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankString() + "|");
        for (int j = 1; j < ladderList.size(); j++) {
            sb.append(getBlankOrLadderString() + "|");
        }
        map.add(sb.toString());
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

    public List<String> getMap() {
        return Collections.unmodifiableList(map);
    }

}
