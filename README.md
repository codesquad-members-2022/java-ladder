# java-ladder

2022 마스터즈 백엔드 사다리 게임 프로젝트

## 프로젝트 구조

```text
└── app
    └── jinan159
        ├── Application.java
        └── ladder
            ├── LadderGame.java
            ├── config
            │    └── GameConfig.java
            ├── domain
            │    ├── LadderElement.java
            │    ├── Participant.java
            │    └── gamemap
            │        ├── GameMap.java
            │        ├── GameMapColumn.java
            │        └── GameMapRow.java
            ├── utils
            │    └── StringUtils.java
            ├── validation
            │    └── InputValidator.java
            └── view
                ├── InputView.java
                └── OutputView.java

```

### 프로젝트 설명

#### 1. 프로젝트의 시작점, Application 클래스

전체 프로젝트의 시작점은 `Application` 클래스 입니다.

```java
public class Application {

    private static final String ALERT_UNEXPECTED_TERMINATION = "프로그램이 예기치 않게 종료되었습니다.";
    private static final int NAME_LENGTH = 5;

    public static void main(String[] args) {
        try {
            LadderGame game = LadderGame.createWithNameLength(NAME_LENGTH);
            game.startGame();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ALERT_UNEXPECTED_TERMINATION);
        }
    }

}
```

main 메소드에서 IOException 을 처리하고 있는데요, 이 예외가 발생했다는 것은 게임을 정상적으로 실행할 환경이 아니라는 것 입니다.<br>
그래서 내부 로직상 발생하는 예외는 각 클래스에서 처리하지만, IOException 의 경우 Application 으로 throw 하여 공통으로 처리합니다.<br>

main 메소드에서는 `LadderGame` 인스턴스를 생성하고, startGame 메소드를 호출하여 게임이 시작됩니다.<br>

#### 2. 사다리 게임의 전체적인 흐름을 관장하는 LadderGame 클래스

```java
public class LadderGame {

    private final GameMap gameMap;
    private final GameConfig config;
    private final List<Participant> participants;

    private LadderGame(int nameLength) {
        config = GameConfig.createWithNameLength(nameLength);

        try (InputView reader = InputView.createWithConfig(config)) {
            this.participants = reader.readParticipants();
            int height = reader.readHeight();
            this.gameMap = new GameMap(participants.size(), height);
        }
    }

    public static LadderGame createWithNameLength(int nameLength) throws IOException {
        return new LadderGame(nameLength);
    }

    // ------- public method ---------
    public void startGame() throws IOException {
        try (OutputView writer = OutputView.createWithConfig(config)) {
            writer.writeParticipants(this.participants);
            writer.writeGameMap(gameMap);
        }
    }

}
```

먼저, `LadderGame` 클래스의 생성자에서는 게임에 필요한 정보들을 미리 입력받게 됩니다.<br>
`Closeable` 인터페이스를 상속받은 `InputView`에서 사용자의 입력 수신 및 검증을 수행합니다.<br>
그리고 입력받은 참가자 정보, 사다리 높이 정보를 `GameMap` 의 생성자로 넘겨주게되면, 내부에서 랜덤하게 맵이 생성됩니다.<br>
startGame 메소드를 실행하며 게임이 시작하게되면 `Closeable` 을 상속한 `OutputView`로 참가자 및 사다리를 출력합니다.<br>

사다리 게임은 이름을 몇자를 받을것이냐에 따라 게임의 입력, 출력이 변화하게 되는데요.<br>
그래서 게임 흐름 전체를 관장하는 `LadderGame` 클래스에 public static final 변수로 해당 상수를 관리하고, 필요한 곳에서 참조합니다.<br>

#### 3. 사용자의 입력값 반환을 보장하는 InputView

먼저 참조하는 곳은, 입력 로직입니다.

```java
public class InputView implements Closeable {

    private final static String SPLITER = ",";
    private final static String Q_NAMES_OF_PARTICIPANTS = "참여할 사람을 입력해주세요.(5자 이하, 이름은 쉼표 '" + SPLITER + "' 로 구분해주세요.)";
    private final static String Q_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?(1개 이상)";
    private final static String ALERT_NUMBER_REQUIRED = "(주의) 숫자만 입력해 주세요.";

    private final Scanner sc;
    private final InputValidator validator;

    private InputView(GameConfig config) {
        this(System.in, config);
    }

    private InputView(InputStream inputStream, GameConfig config) {
        this.sc = new Scanner(inputStream);
        this.validator = InputValidator.createWithConfig(config);
    }

    public static InputView createWithConfig(GameConfig config) {
        return new InputView(config);
    }

    public List<Participant> readParticipants() {
        System.out.println(Q_NAMES_OF_PARTICIPANTS);
        String[] names = readNames();
        return Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int readHeight() {
        System.out.println(Q_MAX_LADDER_HEIGHT);
        return readPositiveNumber();
    }
    
    // ... 생략
  
}
```

처음에는 `InputView` 에서 readParticipants, readHeight 메소드의 반환값을 Optional 로 감싸려고 했었습니다.<br>
하지만 그렇게 하지 않고, InputView 내부에서 검증과 재입력 요청 처리를 하여 정확한 반환값을 반환하도록 만들었습니다.<br>
이런 구조로 만들어서 `LadderGame` 은 입력과 검증은 `InputView` 가 다 해준다고 믿고 게임 전체 흐름에만 집중할 수 있게 됩니다.<br>

여기서 readParticipants 메소드와 readHeight 메소드를 살펴보겠습니다.<br>

readParticipants 메소드는 참가자 정보를 읽는 메소드입니다.<br>
참가자 정보를 물어보는 메세지를 출력하고, readNames 메소드로 이름들을 읽어옵니다.<br>
readNames 내부에서는 `이름,이름,이름 ... ` 형식으로 입력을 받고 이름들을 문자열 배열로 반환합니다.<br>
그런데 만약 readNames 메소드에서 입력값을 검증도 하는데요, 만약 검증에 실패한다면 재귀호출을 통해 재입력 요청을 하게 됩니다.<br> 
그리고 이 이름들로 참가자 객체인 `Participant` 를 생성하여 `List` 형태로 반환합니다.<br>

readHeight 메소드는 사다리 높이 정보를 읽는 메소드입니다.<br>
마찬가지로 높이를 물어보는 메세지를 출력하고, readPositiveNumber 메소드로 양수를 읽어옵니다.<br>

#### 4. 사다리 게임맵을 관리하는 GameMap 클래스

이렇게 입력받은 참가자 정보, 사다리 높이로 `GameMap`을 초기화 하게 되는데요.<br>

```java
public class GameMap {

    private final static String ALERT_WRONG_POINT_ACCESS = "잘못된 좌표로 접근하셨습니다.";

    private final List<GameMapRow> gameMap;
    private final int width;
    private final int height;

    public GameMap(int participantCount, int height) {
        this.width = participantCount * 2;
        this.height = height;
        gameMap = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            gameMap.add(new GameMapRow(width));
        }

        prepareGameMap(this);
    }

    public LadderElement get(int x, int y) {
        return gameMap.get(y)
                .getColumn(x)
                .orElseThrow(()->new IllegalStateException(ALERT_WRONG_POINT_ACCESS))
                .getElement();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String gameMapToString() {
        StringBuilder sb = new StringBuilder();

        for (GameMapRow row : this.gameMap) {
            sb.append(rowToString(row));
            sb.append('\n');
        }

        return sb.toString();
    }
    
    // ... 생략
}
```

`GameMap`은 게임 맵을 Table 형태로 저장합니다.<br>
그래서 각 칸의 정보는 `GameMapColumn`이 저장하고, 이를 담는 `GameMapRow`를 `GameMap`이 보관합니다.<br>
이러한 구조 덕분에, 좌표로 특정 위치로 접근할 수 있습니다.<br>

이렇게 각 클래스에게 역할과 책임을 부여하여, 각자 자기가 맡은 역할에만 최대한 집중할 수 있도록 구성하였습니다.<br>
객체간 연관관계를 유연하게 만들고 싶었지만, 순수 자바만 사용하는 환경에서는 어떤 구현체를 사용할 것인지 선언을 해줘야 해서
유연한 관계를 만들 수 없었습니다.
그래서 객체가 각자 한가지 역할만 갖고 짧고 단순한 코드로 동작하게 하여, 나중에 리펙토링하기 부담없는 구조로 만들었습니다.<br>
