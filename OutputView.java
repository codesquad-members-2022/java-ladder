import java.util.List;

public class OutputView {
    private static OutputView ov;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (ov == null) {
            ov = new OutputView();
        }
        return ov;
    }

    public void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public void printPeoples(List<String> peoples) {
        for (String people : peoples) {
            System.out.printf(" %-5s", people);
        }
        System.out.println();
    }
}
