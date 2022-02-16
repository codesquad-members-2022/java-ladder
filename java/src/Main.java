import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        List<String> people = input.getPeople();
        int hight = input.getHight();

        Ladder ladder = new Ladder(people.size(), hight);
        Output output = new Output();
        output.printLadder(ladder);
    }

}
