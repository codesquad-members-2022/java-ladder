package application.domain.result;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public String output() {
        return results.stream().map(Result::toString).reduce("", (s1, s2) -> s1 + s2) + '\n';
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
