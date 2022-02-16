package model.ladder;

import exception.WrongInputException;
import io.Input;
import io.Output;
import model.Ladder;

public class LadderGame {

    int userCount;
    int ladderMaxHigh;
    public void run() {
        inputValue();
    }

    private void inputValue() {
        Input input = new Input();
        Output output = new Output();

        while (true) {
            try {
                userCount = output.printUserCountBar(input);
                ladderMaxHigh = output.printLadderMaxHighBar(input);
                createLadder(userCount, ladderMaxHigh);
                break;
            } catch (WrongInputException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
        input.close();
    }

    private void createLadder(int userCount, int ladderHigh) {
        Ladder ladder = new Ladder(userCount, ladderHigh);

    }
}
