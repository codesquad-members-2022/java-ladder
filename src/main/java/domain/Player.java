package domain;

public class Player {

    private final String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void ride(Ladder ladder) {
        for (int i = 0; i < ladder.getLadderHeight(); i++) {
            movePosition(ladder,i);
        }
    }

    private void movePosition(Ladder ladder, int row) {
        int currentPosition = position;
        if(ladder.isStep(row,currentPosition)) {
            moveLeft();
        }
        if(ladder.isStep(row,currentPosition+1)) {
            moveRight();
        }
    }

    private void moveLeft() {
        position--;
    }

    private void moveRight() {
        position++;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean isCorrectPosition(int position) {
        return this.position == position;
    }

    public String findNameWithPosition(int position) {
        if(isCorrectPosition(position)) {
            return this.name;
        }
        throw new IllegalArgumentException();
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
