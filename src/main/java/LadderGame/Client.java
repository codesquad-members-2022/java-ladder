package LadderGame;

import java.util.Scanner;

public class Client {
    // TODO: 2022/02/16
    //  사다리 게임에 참여하는 플레이어의 이름을 최대 5글자까지 부여할 수 있다.
    //  사다리 출력시 이름도 같이 출력한다.
    //  사람 이름은 쉼표(,)를 기준으로 구분한다.
    //  사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    //  사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    //  |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

    public Client() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        Output.printUserCountNoti();
        int n = sc.nextInt();

        Output.printLadderCountNoti();
        int m = sc.nextInt();

        LadderGame ladderGame = new LadderGame();
        ladderGame.init(n, m);
        sc.close();
    }
}