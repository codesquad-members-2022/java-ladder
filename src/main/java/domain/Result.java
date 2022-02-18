package domain;


public class Result {
    private final String name;

    private Result(String name) {
        this.name = name;
    }

    public static Result createResult(String name) {
        return new Result(name);
    }

    public String getName() {
        return name;
    }
}
