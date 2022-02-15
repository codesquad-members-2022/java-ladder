public class Application {
    private InputView iv;
    private OutputView ov;
    private Controller controller;

    public Application(){
        this.iv = new InputView();
        this.ov = OutputView.getInstance();
        this.controller = Controller.getInstance();
    }


    public void run(){
        System.out.println("참여할 사람은 몇 명인가요?");
        int memberCount = iv.inputIntValue();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = iv.inputIntValue();

        Ladder ladder = controller.getLadder(memberCount,height);
        ov.printLadder(ladder);
    }
}
