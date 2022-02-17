import java.util.Arrays;

public class OutputManager {
    public void println(String message) {
        System.out.println(message);
    }

    public void printLadderModel(Ladder ladder) {
        ladder.getNameTags().stream()
                .forEach(nameTag -> System.out.print(nameTag.getNameTag()));
        println("");
        ladder.getLadderRows().stream()
                .forEach(LadderRow -> System.out.println(LadderRow.getRow()));
    }
}
