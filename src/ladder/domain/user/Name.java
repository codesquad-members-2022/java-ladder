package ladder.domain.user;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean equalTo(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return this.name;
    }

}
