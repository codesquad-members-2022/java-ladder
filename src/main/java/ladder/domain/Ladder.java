package ladder.domain;

import java.util.*;

public class Ladder {
    private final static Random random = new Random();
    private List<Person> personList;
    private List<Line> map = new ArrayList<>();

    public Ladder(List<Person> personList, int ladderHeight) {
        this.personList = personList;
        initMap(ladderHeight);
    }

    private void initMap(int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
//            addMapLine();
            map.add(new Line(random.nextInt(getPersonCount())));
        }
    }
//
//    private void addMapLine() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getBlankString());
//
//        int randomNumber = random.nextInt(getPersonCount() - 1);
//        for (int j = 0; j < getPersonCount() - 1; j++) {
//            sb.append(getBlankOrLadderString(j, randomNumber));
//        }
//        map.add(sb.toString());
//    }
//
//    private String getBlankOrLadderString(int index, int randomNumber) {
//        if (index == randomNumber) {
//            return getLadderString();
//        }
//        return getBlankString();
//    }

    private String getBlankString() {
        return "     |";
    }

    private String getLadderString() {
        return "-----|";
    }

    public List<Line> getMap() {
        return Collections.unmodifiableList(map);
    }

    public List<Person> getPersonList() {
        return Collections.unmodifiableList(personList);
    }

    public int getPersonCount() {
        return personList.size();
    }
}
