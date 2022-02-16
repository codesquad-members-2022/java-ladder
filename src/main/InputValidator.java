package main;

import java.util.Arrays;

public class InputValidator {
    public void isPosNumber(int num) {
        if (num <= 0) {
            throw new NumberFormatException("1 이상의 자연수만 입력해주세요");
        }
    }

    public void isInRange(String[] names, int max) {
        Arrays.stream(names).filter(s -> s.length() > max).findAny().ifPresent(s -> {
            throw new IllegalArgumentException("이름을 " + max + "글자 이하로 입력해주세요.");
        });
    }
}
