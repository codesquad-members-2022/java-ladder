package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;

import java.util.List;

public class OutputView {

    public static void printLadderMap(Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPerson(ladder.getPersonList());
        printLineList(ladder.getLineList(), ladder.getPersonCount());
    }

    private static void printPerson(List<Person> personList) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < personList.size(); i++) {
            String name = personList.get(i).getName();
            sb.append(String.format("%5s", name) + " ");
        }
        System.out.println(sb);
    }

    private static void printLineList(List<Line> lineList, int personCount) {
        for (Line line : lineList) {
            printLine(line, personCount);
        }
    }

    private static void printLine(Line line, int personCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankString());
        for (int i = 0; i < personCount - 1; i++) {
            appendString(line, sb, i);
        }
        System.out.println(sb);
    }

    private static void appendString(Line line, StringBuilder sb, int coordinate) {
        if (line.isLadder(coordinate)) {
            sb.append(getLadderString());
        } else {
            sb.append(getBlankString());
        }
    }

    private static String getBlankString() {
        return "     |";
    }

    private static String getLadderString() {
        return "-----|";
    }
}
