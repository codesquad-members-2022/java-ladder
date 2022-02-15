
# java-ladder

2022 마스터즈 백엔드 사다리 게임 프로젝트

---

## 개발 환경
- jdk : jdk11
- IDE : IntelliJ Ultimate(2021.3.2)

---

## 빌드 환경

- Project : Gradle Project
- Dependencies(의존 라이브러리)
  - 테스트 편의를 위해 gradle을 통해 테스트 라이브러리를 추가했다.
      - JUnit Jupiter API : JUnit5의 "junit-jupiter-api" 모듈
      - AssertJ : JUnit 기반 테스트의 표현력 부족을 보완한 테스트 라이브러리

  - **그 외에는 추가한 라이브러리는 없다.**

---

## Main 클래스

```java

public class Main {

    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication();
        gameApplication.run();
    }
}
```
- main 메서드가 정의된 클래스
- GameApplication 인스턴스 생성
- run 메서드 호출

---

## GameApplication
```java
public class GameApplication {

  private AppConfig ac;
  private InputView inputView;
  private OutputView outputView;
  private LadderGameService ladderGameService;

  public GameApplication() {
    init();
  }

  private void init() {
    ac = AppConfig.getInstance();
    inputView = ac.inputView();
    outputView = ac.outputView();
    ladderGameService = ac.ladderGameService();
  }

  public void run() {
    initLadderGame();
    Ladder ladder = ladderGameService.getCopyOfResultLadder();
    outputView.printLadder(ladder);
    ac.close();
  }

  public void initLadderGame() {
    int entry = inputView.inputEntry();
    int height = inputView.inputHeight();
    ladderGameService.initLadderGame(entry,height);
  }
}
```
- 실제 실행 역할을 담당함.
- 생성자 호출 시, init 메서드를 호출하여 초기화
- AppConfig 인스턴스를 기반으로, 의존 인스턴스들을 초기화한다.
- run 메서드를 호출하면 실행됨

---

## AppConfig 클래스
```java

public class AppConfig {

  private static AppConfig instance = new AppConfig();

  private AppConfig() {}

  public static AppConfig getInstance() {
    return instance;
  }

  public LadderGameService ladderGameService() {
    return LadderGameServiceImpl.getInstance(ladderFactory());
  }

  public LadderFactory ladderFactory() {
    return LadderFactoryImpl.getInstance();
  }

  public Validator validator() {
    return ValidatorImpl.getInstance();
  }

  public InputView inputView() {
    return InputViewImpl.getInstance(validator());
  }

  public OutputView outputView() {
    return OutputViewImpl.getInstance();
  }

  public void close() {
    try {
      inputView().close();
    } catch (Exception e) {
      System.out.println("자원 반환 실패");
    }
  }
}
```
- 주요 싱글톤 인스턴스들의 의존성을 관리해주는 설정 클래스 (싱글톤)
- 자원을 반환하려면, 수동으로 close 메서드를 호출하여 자원을 반환해야함.

---
## LadderGame

```java
public class LadderGame {

  private final Ladder ladder;

  LadderGame(Ladder ladder) {
    this.ladder = ladder;
  }

  Ladder getLadder() {
    return this.ladder;
  }
}
```
- 사다리 게임을 정의한 LadderGame 클래스를 정의
- 같은 패키지 안에서만 생성 가능
- getter로 ladder을 반환함. (같은 패키지 안에서만 호출가능)

---
## Ladder
```java
public class Ladder {

  private final LadderElement[][] ladderElements;

  Ladder(LadderElement[][] ladderElements) {
    this.ladderElements = ladderElements;
  }

  public LadderElement[][] getLadderElements() {
    return ladderElements;
  }
}
```
- 사다리를 정의한 클래스
- `LadderElement`를 이차원배열로 함.
- 여기서 많은 고민을 했다.
  - 사다리 내용물을 출력하려면 ladderElements 정보가 필요함
  - Output에 ladderElements 배열정보를 넘기기엔, 변경가능성이 커져버림.
  - 그렇다고 ladderElements 측이 toString과 같은 메서드를 가지고 있기엔 이 역시도, ladder의 책임이 불필요하게 늘어난다.

---

## LadderElement (enum)
```java
public enum LadderElement {

    VERTICAL_LINE('|'),
    HORIZONTAL_LINE('-'),
    EMPTY_LINE(' ');

    private char symbol;

    LadderElement(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
```
- 사다리의 구성 요소들을 enum으로 정의
- 요소
  - 세로라인은 VERTICAL_LINE
  - 가로라인은 HORIZONTAL_LINE
  - 빈 가로라인(사다리 가로라인이 없는 경우)은 EMPTY_LINE

---

## LadderFactory (interface)
```java
public interface LadderFactory {

  Ladder create(int entry, int height);
  Ladder copy(Ladder original);
}

```
- Ladder을 생성하고, 복사하는 역할
- 구현체 : LadderFactoryImpl

---

## LadderGameService (interface)
```java
public interface LadderGameService {

  void initLadderGame(int entry, int height);
  Ladder getCopyOfResultLadder();
}
```
- LadderGame에 관한 핵심적인 비즈니스 로직을 담당함
- initLadderGame : 사다리 게임 초기화
- getCopyOfResultLadder : 게임의 결과로부터, Ladder를 반아온 뒤, Ladder을 복사하여 반환.
- 구현체 : LadderGameServiceImpl

---

## Validator (interface)
```java
public interface Validator {

  void entryValidate(int entry);
  void heightValidate(int height);

}
```
- 입력값에 대한 유효성 검사, 유효하지 않으면 예외를 throw
- 구현체 : ValidatorImpl

---

## InputView (interface)
```java
public interface InputView {

    int inputEntry();
    int inputHeight();
    void close();
}
```
- InputView : 사용자로부터 입력을 받는 역할을 정의한 인터페이스
  - inputEntry : 참가자 수
  - inputHeight : 사다리 높이
  - close : 입력에 사용했던 자원 반환
- InputViewImpl : 구현체

---

## OutputView (interface)
```java
public interface OutputView {

    void printLadder(Ladder ladder);

}
```
- OutputView : 결과 출력 역할을 담당하는 인터페이스
- OutputViewImpl : 구현체

---
