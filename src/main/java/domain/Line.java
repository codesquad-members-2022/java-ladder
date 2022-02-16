package domain;

public class Line {
    public static final String INVALID_INPUT_PERSON_NUMBER_MESSAGE = "사람수는 1명 이상만 가능합니다.";
    public static final String INVALID_INPUT_LADDER_POSITION_MESSAGE = "ladder의 시작 지점은 0 ~ (사람수-1) 까지만 가능합니다.";
    public static final String ALREADY_MAKE_LADDER_MESSAGE = "이미 해당지점에 사다리가 생성되어 있습니다.";
    private final int numOfPerson;
    private final int[] columns;

    public Line(int numOfPerson) {
        if(!isValidPersonNumber(numOfPerson)){
            throw new IllegalArgumentException(INVALID_INPUT_PERSON_NUMBER_MESSAGE);
        }
        this.numOfPerson = numOfPerson;
        this.columns = new int[numOfPerson];
    }

    private boolean isValidPersonNumber(int numOfPerson) {
        return numOfPerson > 0;
    }

    public int length() {
        return columns.length;
    }

    public boolean makeLadderAt(int startPosition) {
        if(!isValidLadderStartPosition(startPosition)){
            throw new IllegalArgumentException(INVALID_INPUT_LADDER_POSITION_MESSAGE);
        }
        if(!isAlreadyMakeLadder(startPosition)){
            throw new IllegalArgumentException(ALREADY_MAKE_LADDER_MESSAGE);
        }
        columns[startPosition] = 1;
        columns[startPosition + 1] = 1;
        return true;
    }

    private boolean isAlreadyMakeLadder(int startPosition) {
        return !isMarkedPosition(startPosition) && !isMarkedPosition(startPosition+1);
    }

    private boolean isValidLadderStartPosition(int startPosition) {
        return startPosition >=0 && startPosition < numOfPerson;
    }

    public boolean isMarkedPosition(int position) {
        return columns[position] == 1;
    }
}
