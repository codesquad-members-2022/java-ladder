import view.InputView;
import view.OutputView;
import view.QueryText;

public class Main {

    public static void main(String[] args) {
        OutputView.printNumOfPeopleQueryText();
        int numOfPeople = InputView.giveInt();

        OutputView.printMaxHeightOfLadderQueryText();
        int maxHeightOfLadder = InputView.giveInt();

        Game game = new Game();
        game.init(numOfPeople, maxHeightOfLadder);


    }
}
