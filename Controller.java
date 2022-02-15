public class Controller {
    private static Controller controller;

    private Controller(){}

    public static Controller getInstance(){
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }

    public Ladder getLadder(int memberCount, int height){
        return new Ladder(memberCount,height);
    }
}
