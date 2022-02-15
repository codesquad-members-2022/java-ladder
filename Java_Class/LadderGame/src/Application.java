public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        LadderMaker maker = new LadderMaker();
        Output output = new Output();
        Controller controller = new Controller(input, maker, output);
        controller.runApp();
    }
}
