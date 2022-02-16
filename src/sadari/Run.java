package sadari;

public class Run {
    public void run(){
        InputView i = new InputView();
        i.inputPlayers();
        int people = i.numberOfPlayers();
        int height = i.inputHeight();
        i.printNames();
        Ladder l = new Ladder(people,height);
        i.close();
    }
}
