package domain.item;

import java.util.HashMap;
import java.util.Map;

public class ItemCreator {
    public static Map<Integer, Item> createResultMap(String[] results) {
        int i = 0;
        Map<Integer, Item> map = new HashMap<>();
        for (String result : results) {
            map.put(i, Item.createResult(result));
            i += 2;
        }
        return map;
    }
}
