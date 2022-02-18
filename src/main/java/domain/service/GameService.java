package domain.service;

import domain.Ladder;
import domain.Result;
import domain.User;

import java.util.HashMap;
import java.util.Map;

public class GameService {
    private Map<String,User> users;
    private Map<Integer, Result> results;
    private Ladder ladder;

    public GameService( int lineHeight, String[] users,String[] results) {

        this.users = getUserMap(users);
        this.results = getResultMap(results);
        this.ladder = new Ladder(lineHeight, calculateLadderWidth());
    }

    public Result getSingleResult(String username) {
        int userPoint = users.get(username).getPoint();
        //게임 로직
        return results.get(userPoint);
    }

    private Map<String,User> getUserMap(String[] users) {
        int i = 0;
        Map<String, User> map = new HashMap<>();
        for (String user : users) {
            map.put(user, User.createUser(user, i));
            i += 2;
        }
        return map;
    }

    private Map<Integer, Result> getResultMap(String[] results) {
        int i = 0;
        Map<Integer, Result> map = new HashMap<>();
        for (String result : results) {
            map.put(i,Result.createResult(result));
            i += 2;
        }
        return map;
    }



    private int calculateLadderWidth() {
        return users.size() * 2 - 1;
    }
}
