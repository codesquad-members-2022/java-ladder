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
        maker.makeLadder(input.getNameList().size(),input.getHeight());

        // List<List<String>> 을 받도록 수정 예정
        // String[][] ladder = maker.getLadderList();
        // output.printConsole(ladder);
    }
}
