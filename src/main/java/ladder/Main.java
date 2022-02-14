package ladder;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Ladder ladder = new Ladder();
        Output output = new Output();
        int people = input.getNumber("참여할 사람은 몇 명인가요?");
        int height = input.getNumber("참여할 사람은 몇 명인가요?");
        output.printLadder(ladder.makeLadder(people, height));
        input.close();
    }
}
