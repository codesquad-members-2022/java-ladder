package ladder;

public class Validator {
    public String[] CheckMaximumNumberCharacters(String[] participantArr, int maxNumCharacters) throws IllegalArgumentException {
        for (String name : participantArr) {
            checkNameExceedsMaximum(name,maxNumCharacters);
        }
        return participantArr;
    }

    private void checkNameExceedsMaximum(String name, int maxNumCharacters) throws IllegalArgumentException{
        if (maxNumCharacters < name.length()) {
            throw new IllegalArgumentException("참가자 이름이 " + maxNumCharacters + "넘지 않도록 작성하세요.");
        }
    }
}
