public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        int people = input.getPeople();
        int hight = input.getHight();

        Ladder ladder = new Ladder(people, hight);
        Output output = new Output();
        output.printLadder(ladder);
    }

}
