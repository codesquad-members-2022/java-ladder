public class Main {
    public static void main(String[] args) {
        int numberOfPeople;
        int heightOfLadder;
        Output.messageAboutNumber();
        numberOfPeople = Input.getNumber();

        Output.messageAboutHeight();
        heightOfLadder = Input.getNumber();

        Input.scannerClose();

        Ladder ladder = new Ladder(numberOfPeople, heightOfLadder);
        Output.messageAboutLadder(ladder.Info());
    }
}
