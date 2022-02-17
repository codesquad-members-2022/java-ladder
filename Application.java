import java.util.List;

public class Application {
    private final InputView iv;
    private final OutputView ov;
    private final Controller controller;

    public Application(){
        this.iv = new InputView();
        this.ov = OutputView.getInstance();
        this.controller = Controller.getInstance();
    }
    public void run(){
        System.out.println("참여할 사람은 몇 명인가요?");
        //사람 이름 리스트로 받기
        List<String> peoples;
        peoples = iv.inputPeoples();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = iv.inputIntValue();

        Ladder ladder = controller.getLadder(peoples.size(),height);

        ov.printPeoples(peoples);
        ov.printLadder(ladder);
    }
}
