public class App {
    public static void main(String[] args){

        int userNumber = InputView.getUserNumberInput();

        int sadariNumber = InputView.getSadariNumberInput();

        Sadari s = new Sadari(userNumber, sadariNumber);

        OutputView.printGraphicalSadari( s.getSadari() );

    }
}