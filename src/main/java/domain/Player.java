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
            movePosition(ladder, i);
        }
    }

    private void movePosition(Ladder ladder, int row) {
        int currentPosition = position;
        if (currentPosition < ladder.getWidth() && ladder.isStep(row, currentPosition)) {
            moveRight();
        }
        if (currentPosition > 0 && ladder.isStep(row, currentPosition - 1)) {
            moveLeft();
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
        if (isCorrectPosition(position)) {
            return this.name;
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return this.name;
    }


}
