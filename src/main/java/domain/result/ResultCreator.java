package domain.result;

import java.util.HashMap;
import java.util.Map;

public class ResultCreator {
    public static Map<Integer, Result> createResultMap(String[] results) {
        int i = 0;
        Map<Integer, Result> map = new HashMap<>();
        for (String result : results) {
            map.put(i,Result.createResult(result));
            i += 2;
        }
        return map;
    }
}
