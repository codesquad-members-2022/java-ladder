import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {
		InputView inputView = new InputView();
		int[] input = inputView.getInput();

		Ladder ladder = new Ladder();

		OutView outView = new OutView();
		outView.print(ladder.makeLadder(input[0], input[1]));
	}
}
