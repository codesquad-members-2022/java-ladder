
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
