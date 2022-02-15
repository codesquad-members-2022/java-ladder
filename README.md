
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

    public GameApplication() {
        init();
    }

    private void init() {
        AppConfig ac = AppConfig.getInstance();
    }

    public void run() {
        System.out.println("Hello, World!");
        System.out.println("Bye, World!");
    }
}
```
- 실제 실행 역할을 담당함.
- 생성자 호출 시, init 메서드를 호출하여 초기화
- AppConfig 인스턴스를 기반으로 초기화한다.
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

}
```
- 주요 싱글톤 인스턴스들의 의존성을 관리해주는 설정 클래스 (싱글톤)

---
## LadderGame

```java
public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

}
```
- 사다리 게임을 정의한 LadderGame 클래스를 정의
- getter로 ladder을 반환함.

---
## Ladder
```java
public class Ladder {

    private LadderElement[][] ladderElements;

    public Ladder(LadderElement[][] ladderElements) {
        this.ladderElements = ladderElements;
    }

    public int width() {
        return ladderElements[0].length;
    }

    public int height() {
        return ladderElements.length;
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
