package application.domain.result;

import application.domain.player.Player;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Result getResult(int index) {
        return results.get(index);
    }

    public String output() {
        return results.stream().map(Result::output).reduce("", (s1, s2) -> s1 + s2) + '\n';
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
