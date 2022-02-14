
# java-ladder

2022 마스터즈 백엔드 사다리 게임 프로젝트

---

## 개발 환경
- jdk : jdk11
- IDE : IntelliJ Ultimate(2021.3.2)

---

## 빌드 환경

- Project : Gradle Project
- Spring Boot : 2.6.3
- Dependencies(의존 라이브러리)
  - Lombok : 롬복에서 지원하는 어노테이션을 달아주면, Getter, Setter, 생성자 등을 컴파일 시 자동으로 생성해준다.

---

## AppConfig 클래스

```java
@Configuration
@ComponentScan
public class AppConfig {

    @Bean (destroyMethod = "close")
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
```
- `@Configuration` : 프로젝트 전반적인 Bean 관리 Configuration 클래스
- `@ComponentScan` : 자신과 같은 경로 및 하위의 모든 클래스들 중에서 `@Component` 어노테이션이 달린 클래스를 찾아냄
- 수동 등록 빈
  - `Scanner` : 사용자 입력을 받는 용도. 어플리케이션이 종료되면 자원을 반환하도록 close 메서드를 소멸 메서드로 설정함.

---

## LadderGame

```java
@Component
@Setter @Getter
public class LadderGame {

    private LadderElement[][] ladder;

}
```
- 사다리 게임을 정의한 LadderGame 클래스를 정의
- getter로 이차원 배열을 반환함.
- setter를 통해 사다리를 설정함.

---

## LadderElement (enum)
```java
@RequiredArgsConstructor
@Getter
public enum LadderElement {

    VERTICAL_LINE("-"),
    HORIZONTAL_LINE("|"),
    EMPTY_LINE(" ");

    private final String symbol;

}
```
- `Ladder`의 구성 요소들을 enum으로 정의
- 요소
  - 세로라인은 VERTICAL_LINE
  - 가로라인은 HORIZONTAL_LINE
  - 빈 가로라인(사다리 가로라인이 없는 경우)은 EMPTY_LINE

---

## Validator (interface)
```java
public interface Validator {

  void entryValidation(int entry);
  void heightValidate(int height);
}
```
- 유효성을 검사하는 역할을 정의한 인터페이스
- 구현체 : ValidatorImpl

---

## InputView (interface)
```java
public interface InputView {

    int inputEntry();
    int inputHeight();
}
```
- 사용자로부터 입력을 받는 역할을 정의한 인터페이스
- 구현체 : InputViewImpl

---