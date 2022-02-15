public class Controller {
    private final Input input;
    private final LadderMaker maker;
    private final Output output;

    public Controller(Input input, LadderMaker maker, Output output) {
        this.input = input;
        this.maker = maker;
        this.output = output;
    }

    protected void runApp() {
        input.processInput();
        int[] inputArray = input.getInputAsArray();

        maker.makeLadder(inputArray);
        String[][] ladder = maker.getLadderArray();

        output.printConsole(ladder);
    }
}
