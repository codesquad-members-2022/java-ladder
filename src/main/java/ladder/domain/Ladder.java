package ladder.domain;

import java.util.*;

public class Ladder {
    private final static Random random = new Random();
    private List<Person> personList;
    private List<Line> lineList = new ArrayList<>();

    public Ladder(List<Person> personList, int ladderHeight) {
        if (ladderHeight < 0) {
            throw new IllegalArgumentException("사다리 높이는 0 이상 이어야 합니다.");
        }
        this.personList = personList;
        initMap(ladderHeight);
    }

    private void initMap(int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            lineList.add(new Line(random.nextInt(getPersonCount() - 1)));
        }
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }

    public List<Person> getPersonList() {
        return Collections.unmodifiableList(personList);
    }

    public int getPersonCount() {
        return personList.size();
    }
}
