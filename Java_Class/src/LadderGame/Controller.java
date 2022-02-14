package LadderGame;

import java.util.Arrays;

public class Controller {
    private Input input;
    private LadderMaker maker;

    public Controller(Input input, LadderMaker maker) {
        this.input = input;
        this.maker = maker;
    }

    protected void runApp(){
        input.processInput();
        int[] inputArray = input.getInputArray();
        maker.makeLadder(inputArray);
        String[][] ladder = maker.getLadder();
        System.out.println(Arrays.deepToString(ladder));
    }
}
