package view;

import domain.Line;
import domain.ladder.Ladder;

import java.util.List;

public class OutputView {
    public static void showLadder(Ladder ladder, String[] inputNames, String[] results) {
        List<Line> lines = ladder.getLines();

        for(String name : inputNames){
            System.out.print(addPadding(name));
        }
        System.out.println();
        for (Line line : lines) {
            line.show();
        }

        for(int i = 0; i < inputNames.length; i++){
            System.out.println(inputNames[i] + " : " + results[ladder.run(i)]);
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
            default:
                return name + " ";
        }
    }
}
