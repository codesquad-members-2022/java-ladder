package LadderGame;

import java.util.Arrays;

public class Controller {
    private final Input input;
    private final LadderMaker maker;

    public Controller(Input input, LadderMaker maker) {
        this.input = input;
        this.maker = maker;
    }

    protected void runApp() {
        input.processInput();

            int[] inputArray = input.getInputArray();
            maker.makeLadder(inputArray);
            String[][] ladder = maker.getLadder();

            /* 테스트..Junit 배워야하는데.. */
            Arrays.stream(ladder) // Stream<String[]>
                .map(i -> Arrays.toString(i)
                    .replace(", ", "")
                    .replace("[", "")
                    .replace("]", ""))
                .forEach(System.out::println);

    }
}
