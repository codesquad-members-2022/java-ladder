import java.util.*;

public class Ladder {
    private final static Random random = new Random();
    private List<Person> personList;
    private List<String> map = new ArrayList<>();

    public Ladder(List<Person> personList, int ladderHeight) {
        this.personList = personList;
        initMap(ladderHeight);
    }

    private void initMap(int ladderHeight) {
        addMapFirstLine();
        for (int i = 0; i < ladderHeight; i++) {
            addMapLine();
        }
    }

    private void addMapFirstLine() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < getPersonCount(); i++) {
            String name = personList.get(i).getName();
            sb.append(String.format("%5s", name) + " ");
        }
        map.add(sb.toString());
    }

    private void addMapLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankString());

        int randomNumber = random.nextInt(getPersonCount() - 1);
        for (int j = 0; j < getPersonCount() - 1; j++) {
            sb.append(getBlankOrLadderString(j, randomNumber));
        }
        map.add(sb.toString());
    }

    private String getBlankOrLadderString(int index, int randomNumber) {
        if (index == randomNumber) {
            return getLadderString();
        }
        return getBlankString();
    }

    private String getBlankString() {
        return "     |";
    }

    private String getLadderString() {
        return "-----|";
    }

    public List<String> getMap() {
        return Collections.unmodifiableList(map);
    }

    public int getPersonCount() {
        return personList.size();
    }
}
