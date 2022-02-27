package domain.user;

public class User {
    private final String name;
    private final int point;


    public User(String user, int point) {
        this.name = user;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
