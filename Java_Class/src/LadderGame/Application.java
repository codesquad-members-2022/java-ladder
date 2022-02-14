package LadderGame;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        LadderMaker maker = new LadderMaker();
        Controller controller = new Controller(input, maker);
        controller.runApp();
    }
}
