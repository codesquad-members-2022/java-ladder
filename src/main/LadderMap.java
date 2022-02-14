package main;

public class LadderMap {

    private final int numPerson;
    private final int numLadder;

    public LadderMap(int numPerson, int numLadder) {
        this.numPerson = numPerson;
        this.numLadder = numLadder;
    }

    @Override
    public String toString() {
        return "LadderMap{" +
            "numPerson=" + numPerson +
            ", numLadder=" + numLadder +
            '}';
    }
}
