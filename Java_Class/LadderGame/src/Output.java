import java.util.List;

public class Output {
    private static String tempSt;
    private static float mid;
    private static float start;
    private static float end;

    public void printNames(List<String> names, int length) {
        for (String st : names) {
            System.out.print(addPadding(st,length));
        }
        System.out.println();
    }

    private String addPadding(String st, int length) {
        tempSt = String.format("%" + length + "s%s%" + length + "s", "", st, "");
        mid = (tempSt.length() / 2);
        start = mid - (length / 2);
        end = start + length;
        return tempSt.substring((int)start, (int)end);
    }

    public void printLadder(List<String> ladder) {
        for (String row : ladder) {
            System.out.printf("%s%s%n", "  ", row);
        }
    }

}
