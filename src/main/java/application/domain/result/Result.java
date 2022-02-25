package application.domain.result;

import application.domain.ladder.Ladder;

public class Result {
    private final String result;

    public Result(String result) {
        this.result = result;
    }

    public String output() {
        return String.format("%-" + (Ladder.INTERVAL + 1) + "s", result);
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
