package sadari;

public class Run {
    public void run(){
        InputView i = new InputView();
        int people = i.inputPeople();
        int height = i.inputHeight();
        Ladder l = new Ladder(people,height);
        i.close();
    }
}
