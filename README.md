# 2022 마스터즈 백엔드 사다리 게임 프로젝트
## 사다리 구현 3단계 - 사다리 모양 개선
- ### 프로젝트 구조
  ```bash
  📘 class 📗 interface
  
  ├── 📁src
  │   ├── 📁main
  │   │    ├── 📁application
  │   │    │   ├── 📘Application.java
  │   │    ├── 📁controller
  │   │    │   ├── 📘LadderController.java
  │   │    ├── 📁message
  │   │    │   ├── 📘InputViewMessage.java  
  │   │    │   └── 📘ShapeMessage.java
  │   │    ├── 📁model.game
  │   │    │   ├── 📁ladder
  │   │    │   │   ├── 📁element
  │   │    │   │   │   ├── 📗Element.java
  │   │    │   │   │   ├── 📘Line.java
  │   │    │   │   │   ├── 📘None.java
  │   │    │   │   │   └── 📘Pole.java
  │   │    │   │   ├── 📘Ladder.java
  │   │    │   │   └── 📘Shape.java
  │   │    │   ├── 📁player
  │   │    │   │   └── 📘Player.java
  │   │    │   └── 📘Game.java
  │   │    ├── 📁util
  │   │    │   ├── 📘GameUtil.java 
  │   │    │   └── 📘Parser.java
  │   │    ├── 📁view
  │   │    │   ├── 📘InputView.java
  │   │    │   └── 📘OutputView.java
  └── └── 📘Main.java
 
  ```
- ### 기능요구사항
  - [x] 사다리 게임에 참여하는 플레이어의 이름을 최대 5글자까지 부여할 수 있다.
  - [x] 사다리 출력시 이름도 같이 출력한다.
  - [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. ***(유동적으로 구현했습니다)***
  - [x] 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - [x] |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

- ### 프로그래밍 요구사항
  - [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - [x] method가 한 가지 일만 하도록 최대한 작게 만들어라.
  - [x] indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  - [x] depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
  - [x] else를 사용하지 마라.
  - [x] 배열 대신 ArrayList와 Generic을 활용해 구현한다.

- ### 결과화면
  