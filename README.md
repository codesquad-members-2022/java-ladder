# java-ladder

2022 마스터즈 백엔드 사다리 게임 프로젝트

- [x] 미션 1 구현
- [x] 미션 2 구현
- [x] 미션 3 구현
- [x] 미션 4 구현
- [x] 미션 5 구현

### mission 1

다음이 리팩토링이기 때문에 리팩토링은 내일 생각해 보려고 그냥 단순히 생각나는 대로 빠르게 구현했다.

사다리 게임은 사다리의 발판(`-`)이 좌우에 동시에 있으면 안 되는데 그냥 랜덤으로 막 가져다가 넣은 것 같아서 약간의 죄책감이 든다.

구현 시에 사다리의 발판(`-`) 사다리의 프레임 (`|`)을 분리해서 발판은 `ladderFoothold` boolean 2차원 배열, 프레임은 `ladderFrame` char 2차원 배열로 나눠서 구현했다.

미션 3 요구 조건을 읽은 후에 미션을 진행하게 돼서 그런지 약간 미래를 생각하고 구현하게 된 것 같다. 이번 주는 이미 늦었으니까 다음 주부터는 다음 요구 조건을 보지 않고 구현을 해야겠다.

<br>

## mission 2

랜덤 로직이 배열을 전체탐색하면서 Math.rand() 값 기준으로 발판을 생성해주고 있었는데 depth 3이라서 제거하고 다른 방법으로 랜덤하게 발판을 만들었다.

`Input` 클래스는 기존에 중복되던 코드를 따로 추출해서 성공적으로 리팩토링을 진행한 것 같다.

`PrintLadder` 클래스는 2차원 배열인 사다리를 출력하다보니 2중 포문과 로직 상 if로 boolean 값을 체크해야 하는 부분이 강제되는데 이를 depth 1을 맞추기 위해 의미없이 메서드 추출을 한 것 같다.
오히려 코드의 가독성이 안좋아진 것 같아서 올바르게 리팩토링을 진행한건지 의문이다.

<br>

## mission 3

3번째 미션 PR 시에 리드미 작성을 까먹었다 😅

배열을 List로 변경하면서 List<List<>>와 같이 하고싶지 않아서 클래스로 나누었다.

사람의 이름을 저장하고, 검증하는 User class, Ladder class에서 `List<LadderLine>`로 사다리를 관리하도록 LadderLine class를 만들었다.

이렇게 클래스를 분리해서 구현을 하니 사다리를 만드는 로직이 배열보다 간단해지고 가독성도 올라가서 좋은 것 같다.

<br>

## mission 4

**간단한 리팩토링 및 코드 수정**

먼저 3단계에서 미흡한 부분을 리팩토링을 진행했습니다. 사용자 이름을 switch 문으로 padding을 붙이던 로직을 변경했고 몇가지 변수 명을 수정했습니다.

또 이름이 5글자 이상일 때 예외를 던지던 로직을 그냥 쿠킴처럼 `jeremy` 입력 시 `jer..`처럼 되도록 변경했습니다.

<br>

**패키지 분리**

지금까지는 패키지 분리를 해본 적이 없어서 어떻게 분리해야 할 지 막막했습니다. 결국 힌트대로 ladder, ladder.view, ladder.domain 으로 분리했습니다.

패키지 구조는 아래와 같습니다.

```
src
└── ladder
    │
    ├── domain
    │   ├── LadderGame.java
    │   ├── LadderLine.java
    │   └── User.java
    │
    ├── view
    │   ├── Input.java
    │   └── PrintLadder.java
    │
    └── GameManager.java
 
test
└── ladder
    └── domain
        ├── LadderLineTest.java
        └── UserTest.java

```

<br>

**단위 테스트**

테스트는 다른 사람의 코드를 어깨너머로 배운게 전부라 junit5만 이용해서 테스트를 진행했습니다.

제일 핵심 로직이라고 판단되는 User class와 LadderLine class에 테스트 코드를 작성했고 결과는 아래와 같습니다.

<br>

테스트 진행한 사항

<img width="470" alt="스크린샷 2022-02-17 19 27 06" src="https://user-images.githubusercontent.com/81368630/154457417-8a7341a1-30cd-4549-836e-90d44db19f9e.png">

코드 커버리지

<img width="810" alt="스크린샷 2022-02-17 19 24 12" src="https://user-images.githubusercontent.com/81368630/154457430-5b858cbc-481c-4e9a-bd91-7a0b8d02d18f.png">

<br>

## mission 5

실행 결과를 입력받고 사다리에서 유저와 결과를 매칭해주는 메소드를 만들어서 Map을 통해 관리를 하도록 했습니다.

동일한 유저가 들어오거나 유저의 결과 입력에 대한 검증은 따로 하지 않고 문제의 요구조건정도만 생각하며 구현했습니다.

LadderGame class에서 `List<LadderLine> ladder`로 ladder를 관리하고 있었는데 유저와 결과를 매칭해주는 메소드의 크기가 커서 Ladder Class로 분리했습니다.

### 고민사항

변수명이 마음에 들지 않는 것이 너무 많습니다.

Q) getter나 setter가 아닌 메소드명이 get이나 set이 포함되어 있어도 되는걸까요??

ex) InputView Class에서 유저의 이름을 입력받는 메소드 명 `getUserName()`, LadderGame Class에서 입력받은 유저이름을 클래스변수에 저장하는 메소드 명 `setUserName()`

위와 같이 메소드명을 지정했는데 마음에 들지 않고 그렇다고 다른 적절한 메소드명이 생각나지 않네요
