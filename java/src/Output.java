import java.util.List;

public class Output {

    List<String> people;

    public Output(List<String> people) {
        this.people = people;
    }

    private void printPeopleName() {
        for (int i = 0; i < people.size(); i++) {
            System.out.print(people.get(i));
        }
        System.out.println();
    }

    private void printOneHight(List<String> ladderOneHight) {
        for (int i = 0; i < ladderOneHight.size(); i++) {
            System.out.print(ladderOneHight.get(i));
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        List<List<String>> frame = ladder.getLadder();
        printPeopleName();
        for (int i = 0; i < frame.size(); i++) {
            printOneHight(frame.get(i));
        }
    }

}

