public class App {
    public static void main(String[] args){

        String[] userNames = InputView.getUsersNames();

        int sadariNumber = InputView.getSadariNumberInput();

        Sadari s = new Sadari(userNames.length, sadariNumber);

        OutputView.printUserNames(userNames);

        OutputView.printGraphicalSadari( s.getSadari() );

    }
}
