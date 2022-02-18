package domain;

public class Player {

    private final String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean isCorrectPosition(int position) {
        return this.position == position;
    }

    public String name2Text() {
        return editNameLength();
    }

    private String editNameLength() {
        if(name.length() > 5) {
            return name.substring(0, 3) + "..";
        }
        return name;
    }
}
