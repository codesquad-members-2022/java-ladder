public class Controller {
    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    protected void runApp() {
        input.processInput();
        LadderMaker ladderMaker = new LadderMaker(input.getNameList().size(), input.getHeight());
        ladderMaker.make();

        output.printNames(input.getNameList(),6);   // [pobi,honux,crong,jk]
        output.printLadder(ladderMaker.getLadderList());    // [{row1},{row2}..]
    }

}
