package view;

import java.util.List;

import domain.Line;

public class Output {
    private static String tempSt;
    private static float mid;
    private static float start;
    private static float end;

    public void printNames(List<String> names, int length) {
        for (int i = 0; i < names.size(); i++) {
            System.out.print(addPadding(names.get(i),length));
        }
        System.out.println();
    }

    String addPadding(String st, int length) {
        tempSt = String.format("%" + length + "s%s%" + length + "s", "", st, "");
        mid = (tempSt.length() / 2);
        start = mid - (length / 2);
        end = start + length;
        return tempSt.substring((int)start, (int)end);
    }

    public void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            String temp = String.join("",line.getLine());
            System.out.printf("%s%s%n", "   ", temp);
        }
    }


}
