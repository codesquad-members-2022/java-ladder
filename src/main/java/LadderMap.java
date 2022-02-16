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
        sb.append(String.format("%8s", ladderList.get(0).getName()));
        for (int i = 1; i < size - 1; i++) {
            sb.append(String.format("%6s", ladderList.get(i).getName()));
        }
        sb.append(String.format("%4s", ladderList.get(size - 1).getName()));
        map.add(sb.toString());
    }

    private void addMapLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankString());
        sb.append("|");
        for (int j = 1; j < ladderList.size(); j++) {
            sb.append(getBlankOrLadderString());
            sb.append("|");
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
