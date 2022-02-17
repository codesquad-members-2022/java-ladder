import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output {

    private static final String INIT_BLANK = "     ";
    private static final List<Integer> FOR_PRESENT_USER_SPACE = Arrays.asList(0, 0, 1, 1, 2, 2);
    private static final List<Integer> FOR_PREVIOUS_USER_SPACE = Arrays.asList(0, 0, 0, 1, 1, 2);

    List<String> people;

    public Output(List<String> people) {
        this.people = people;
    }

    private int getBlankLength(int presentNameLength, int previousNameLength) {
        return INIT_BLANK.length() - FOR_PRESENT_USER_SPACE.get(presentNameLength) - FOR_PREVIOUS_USER_SPACE.get(previousNameLength);
    }

    private void printBlankBetweenPeople (String user, int previousNameLength) {
        int presentNameLength = user.length();
        int blankLength = getBlankLength(presentNameLength, previousNameLength);
        for (int i = 0; i < blankLength; i++) {
            System.out.print(" ");
        }
    }

    private void printPeopleName() {
        int previousNameLength = 0;
        for (int i = 0; i < people.size(); i++) {
            String user = people.get(i);
            printBlankBetweenPeople(user, previousNameLength);
            System.out.print(user);
            previousNameLength = user.length();
        }
        System.out.println();
    }

    private void printOneHight(List<String> ladderOneHight) {
        System.out.print(INIT_BLANK);
        for (int i = 0; i < ladderOneHight.size(); i++) {
            System.out.print(ladderOneHight.get(i));
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        printPeopleName();
        List<List<String>> frame = ladder.getFrame();
        for (int i = 0; i < frame.size(); i++) {
            printOneHight(frame.get(i));
        }
    }

}

