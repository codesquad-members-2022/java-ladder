package view;

import domain.Line;

import java.util.List;

public class OutputView {
    public static void showLadder(List<Line> lines, String[] inputNames) {
        for(String name : inputNames){
            System.out.print(addPadding(name));
        }
        System.out.println();
        for (Line line : lines) {
            line.show();
        }
    }

    private static String addPadding(String name){
        switch (name.length()){
            case 1:
                return "  " + name + "  ";
            case 2:
                return " " + name + "  ";
            case 3:
                return " " + name + " ";
            case 4:
                return name + " ";
            default:
                return name + " ";
        }
    }
}
