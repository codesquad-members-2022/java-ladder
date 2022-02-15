public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        Ladder ladder = new Ladder();
        OutputView output = new OutputView();

        int people = input.getNumber("참여할 사람은 몇 명인가요?");
        int height = input.getNumber("참여할 사람은 몇 명인가요?");

        output.printLadder(ladder.makeLadder(people, height));
        input.close();
    }
}
