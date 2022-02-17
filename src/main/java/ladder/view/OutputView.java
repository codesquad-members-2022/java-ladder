package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Person;

import java.util.List;

public class OutputView {

    public static void printMap(Ladder ladder) {
        printPerson(ladder.getPersonList());
        System.out.println("\n실행 결과\n");
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
}
