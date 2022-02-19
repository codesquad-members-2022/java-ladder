package main.util;

import java.util.ArrayList;
import java.util.List;
import main.domain.HorizontalLine;

public class ListDeepCopy {

    public static List<HorizontalLine> boardDeepCopy(List<HorizontalLine> org) {
        List<HorizontalLine> result = new ArrayList<>();
        for (HorizontalLine item: org){
            result.add(item.clone());
        }
        return result;
    }

    public static <T> List<T> listDeepCopy(List<T> org) {
        List<T> result = new ArrayList<>();
        result.addAll(org);
        return result;
    }
}
