package dukcode.view;

import dukcode.ladder.view.LadderView;

public class PrintView {
    private final LadderView ladderView;

    public PrintView(LadderView ladderView) {
        this.ladderView = ladderView;
    }

    public void printGame() {
        System.out.println("사다리 결과\n");
        System.out.println(ladderView.getPlayersName());
        System.out.println(ladderView.getLadderString());
        System.out.println(ladderView.getResults());
        System.out.println();
    }

    public void printResultOfPlayer(String namePlayer) {
        System.out.println("실행결과");
        System.out.println(ladderView.getStringResultOfPlayer(namePlayer));
        System.out.println();
    }

    public void printResultOfAllPlayer() {
        System.out.println("실행결과");
        String[] names = ladderView.getPlayersNameArray();

        for (String name : names) {
            System.out.println(name + " : " + ladderView.getStringResultOfPlayer(name));
        }
        System.out.println();
    }

    public void printExitMessage() {
        System.out.println();
        System.out.println("게임을 종료합니다.");
    }
}
