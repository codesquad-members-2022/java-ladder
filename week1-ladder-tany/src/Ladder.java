public class Ladder {
    private final int maxHigh;
    private final Person person;
    private char[][] information;

    public Ladder(int maxLadderLength, Person person) {
        this.maxHigh = maxLadderLength;
        this.person = person;
    }

    //TODO 사다리 정보를 설정하는 메서드
    public char[][] initLadderInformation() {
        int personCount = person.getPersonCount() * 2 - 1;
        information = new char[maxHigh][personCount];
        standingLadderFrame(personCount);
        return randomSetting(personCount);
    }

    // TODO 설정된 2차원 배열에서 사다리 프레임을 배치하는 메서드
    private void standingLadderFrame(int personCount) {
        for (int i = 0; i < maxHigh; i++) {
            for (int j = 0; j < personCount; j += 2) {
                information[i][j] = '|';
            }
        }
    }

    // TODO 설정된 2차원 배열에서 랜덤으로 사다리 라인을 배치하는 메서드
    private char[][] randomSetting(int personCount) {
        for (int i = 0; i < maxHigh; i++) {
            for (int j = 1; j < personCount; j += 2) {
                information[i][j] = ((int)(Math.random() * 2)) == 1
                        ? '-' : ' ';
            }
        }
        return information;
    }
}