package main.util;

import java.util.ArrayList;
import java.util.List;

public class ListDeepCopy {
    public static List<List<String>> string2dDeepCopy(List<List<String>> org) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> item: org){
            result.add(string1dDeepCopy(item));
        }
        return result;
    }

    public static List<String> string1dDeepCopy(List<String> org) {
        List<String> result = new ArrayList<>();
        for (String item : org) {
            result.add(new String(item));
        }
        return result;
    }
}
