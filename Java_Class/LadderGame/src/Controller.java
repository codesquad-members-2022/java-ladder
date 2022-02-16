public class Controller {
    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    protected void runApp() {
        input.processInput();
        LadderMaker maker = new LadderMaker(input.getNameList().size(),input.getHeight());
        maker.makeLadder();

        // List<List<String>> 을 받도록 수정 예정
        // String[][] ladder = maker.getLadderList();
        // output.printConsole(ladder);
    }
}
