package src.ladder;

public class OutputView {

    public void printInputPeopleCountGuide() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void printInputLadderHeightInputGuide() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
