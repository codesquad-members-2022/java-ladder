package domain;

public class Line {
    public static final String INVALID_INPUT_PERSON_NUMBER_MESSAGE = "사람수는 1명 이상만 가능합니다.";
    public static final String INVALID_INPUT_LADDER_POSITION_MESSAGE = "ladder의 시작 지점은 0 ~ (사람수-1) 까지만 가능합니다.";
    public static final String ALREADY_MAKE_LADDER_MESSAGE = "이미 해당지점에 사다리가 생성되어 있습니다.";
    private final int[] columns;

    public Line(int numOfPerson) {
        if(!isValidPersonNumber(numOfPerson)){
            throw new IllegalArgumentException(INVALID_INPUT_PERSON_NUMBER_MESSAGE);
        }
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
        if(!isAlreadyExistedLadder(startPosition)){
            throw new IllegalArgumentException(ALREADY_MAKE_LADDER_MESSAGE);
        }
        columns[startPosition] = 1;
        columns[startPosition + 1] = 2;
        return true;
    }

    private boolean isAlreadyExistedLadder(int startPosition) {
        return !isMarkedPosition(startPosition) && !isMarkedPosition(startPosition+1);
    }

    private boolean isValidLadderStartPosition(int startPosition) {
        return startPosition >=0 && startPosition < columns.length;
    }

    public boolean isMarkedPosition(int position) {
        return columns[position] == 1 || columns[position] == 2;
    }

    public int switchLadderLine(int startLine) {
        if(!isMarkedPosition(startLine)){ // 그대로 이동
            return startLine;
        }
        // 우측 처리하기
        if(columns[startLine] == 1){
            return startLine+1;
        }
        // 좌측 이동하기
        return startLine - 1;
    }

    public void show() {
        System.out.print(" ");
        for(int i = 0; i < columns.length-1; i++){
            System.out.print("|");
            if(columns[i] == 1 && columns[i+1] == 2){
                System.out.print("-----");
                continue;
            }
            System.out.print("     ");
        }
        System.out.print("|");
        System.out.println();
    }
}
