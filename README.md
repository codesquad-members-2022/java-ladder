
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

```
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