package domain.gameservice;

import domain.ladder.Ladder;
import domain.ladder.LadderCreator;
import domain.result.Result;
import domain.result.ResultCreator;
import domain.user.User;
import domain.user.UserCreator;

import java.util.Map;

public class GameService {
    private Map<String, User> users;
    private Map<Integer, Result> results;
    private Ladder ladder;

    public GameService( int lineHeight, String[] users,String[] results) {

        this.users = UserCreator.createUserMap(users);
        this.results = ResultCreator.createResultMap(results);
        this.ladder = LadderCreator.createLadder(lineHeight, calculateLadderWidth());
    }

    public Result getSingleResult(String username) {
        int userPoint = users.get(username).getPoint();
        //게임 로직
        return results.get(userPoint);
    }



    private int calculateLadderWidth() {
        return users.size() * 2 - 1;
    }
}
