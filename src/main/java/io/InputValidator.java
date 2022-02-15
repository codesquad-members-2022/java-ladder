package io;

public class InputValidator {

    public int positiveInteger(String input) throws IllegalArgumentException {
        try {
            int n = Integer.parseInt(input);
            if (!isPositiveInteger(n)) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private boolean isPositiveInteger(int n) {
        return 0 < n;
    }
}
