package sadari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputView i = new InputView();
        int people = i.inputPeople();
        int height = i.inputHeight();
        Ladder l = new Ladder();
        l.makeLadder(people,height);
        i.close();
    }
}

