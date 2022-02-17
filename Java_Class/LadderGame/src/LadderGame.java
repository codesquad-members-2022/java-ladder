import domain.Controller;
import view.Input;
import view.Output;

public class LadderGame {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Controller Controller = new Controller(input, output);
        Controller.runApp();
    }
}
