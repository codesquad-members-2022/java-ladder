public class User {
    //사다리 게임에 참여하는 플레이어의 이름을 최대 5글자까지 부여할 수 있다.
    public static int MAX_NAME_LIMIT = 5;
    String name;

    User(String inputName) {
        if (inputName.length() <= MAX_NAME_LIMIT) {
            name = inputName;
            return;
        }
        name = inputName.substring(5);
    }
}
