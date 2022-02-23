package application.domain.result;

import application.domain.ladder.Ladder;

public class Result {
    private final String result;

    public Result(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("%-" + (Ladder.INTERVAL + 1) + "s", result);
    }
}
