import java.util.List;

public class Output {

    public void printConsole(List<String> names) {
        for (String s : names) {
            System.out.printf("%6s", s);
        }
        System.out.println();
    }

    public void printConsole(String row) {
        String space = "    ";
        System.out.printf("%s%s%n", space,row);
    }

}
