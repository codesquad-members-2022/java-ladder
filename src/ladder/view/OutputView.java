package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Group;

public class OutputView {
    private static final String OUTPUT_SINGLE_REWARD = "실행 결과";
    private static final String OUTRO = "굶주린 야생의 %s(이)가 사다리를 먹어치웠다. 다음은 내 차례다. 나를 기억해ㅈ -END-";

    public void printLayout(Ladder ladder, Group playerGroup, Group rewardGroup) {
        System.out.println();
        printGroup(playerGroup);
        printLadder(ladder);
        printGroup(rewardGroup);
        System.out.println();
    }

    public void printResult(String reward) {
        System.out.println(OUTPUT_SINGLE_REWARD);
        System.out.println(reward);
        System.out.println();
    }

    public void printAllResult(String allResult) {
        System.out.println("실행 결과");
        System.out.println(allResult);
    }

    public void printOutro(String endOfProgramSignal) {
        System.out.printf(OUTRO, endOfProgramSignal);
    }

    private void printGroup(Group group) {
        System.out.println(group);
    }

    private void printLadder(Ladder ladder) {
        System.out.print(ladder.render());
    }
}
