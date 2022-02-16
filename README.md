# 2022 마스터즈 백엔드 사다리 게임 프로젝트
## 사다리 구현 3단계 - 사다리 모양 개선

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
  │   │    │   ├── 📘GameUtils.java 
  │   │    │   ├── 📘Parser.java 
  │   │    │   ├── 📘RandomUtils.java 
  │   │    │   └── 📘StringUtils.java
  │   │    ├── 📁view
  │   │    │   ├── 📘InputView.java
  │   │    │   └── 📘OutputView.java
  └── └── 📘Main.java
  ```
  
- ### 프로젝트 설계 및 주요 코드 설명
  ![SmartSelectImage_2022-02-16-19-54-58](https://user-images.githubusercontent.com/47964708/154250336-df7665f3-ee2e-4abb-b906-5520835ad6d6.png)  
  - Game 클래스 내에 Ladder (사다리), List<Player> (플레이어 리스트) 가 존재합니다.
  - Ladder 는 Shape (사다리 형태) 를 포함하고 있으며, 이를 사용하여 형태를 구성합니다.
  - Shape 는 이차원 ArrayList 를 조작하는 일급 객체입니다.
  ```java
  public class Shape<T> {
      private List<List<T>> shape;
  }
  ```
  - Shape 내에 기본적인 조작 addElement, getElement 가 있으며, 편의를 위해 getHeight, getWidth 메서드도 작성했습니다.
  ```java
  public void addElement(int row, T element) {
      if (row >= height) {
          throw new IllegalArgumentException(getRowIndexErrMsg(height));
      }
      if (getSize(row) >= width) {
          throw new IllegalArgumentException(getColIndexErrMsg(row, width));
      }
      shape.get(row).add(element);
  }
  ```
  ```java
  public T getElement(int row, int col) {
      return shape.get(row).get(col);
  }
  ```
  - Ladder 클래스는 위의 두 메서드를 사용하여 사다리를 구성합니다.
  ```java
  private void createLine() {
      int height = shape.getHeight();
      for (int h = 0; h < height; ++h) {
          createLine(h);
      }
  }
  // 세로선을 위치시켜 사다리를 구성하는 메서드 (addElement 메서드 사용)
  private void createLine(int h) {
      int width = shape.getWidth();
      for (int w = 0; w < width; ++w) {
          shape.addElement(h, allocElement(h, w));
      }
  }
  private Element allocElement(int h, int w) {
      return random() * 10 < 5.5 && isValid(h, w) ? shape.line : shape.none;
  }
  // 같은 행 이전 열에 세로선이 놓였는 지 확인하는 메서드 (getElement 메서드 사용)
  private boolean isValid(int h, int w) {
      return w == 0 || (shape.getElement(h, w - 1) != shape.line);
  }
  ```
  - Ladder 내에 Line, None, Pole 객체를 두었습니다.
    - 해당 객체들은 Ladder 가 생성될 때 플레이어의 이름 중 가장 긴 값이 인자로 넘어오면 이를 기반으로 자신이 출력할 문자열을 재구성합니다.
  ```java
  public class Ladder {
      private Line line;
      private None none;
      private Pole pole;
      ...
  
      public Ladder(...int maxNameLength) {
          ...
          this.line = new Line(maxNameLength);
          this.none = new None(maxNameLength);
          this.pole = new Pole();
      }
  }
  ```
  - ### 결과화면
    ![SmartSelectImage_2022-02-16-19-04-57](https://user-images.githubusercontent.com/47964708/154247947-9c18d55d-a7a2-4389-aa24-886fb028a748.png)  
    ![SmartSelectImage_2022-02-16-19-37-39](https://user-images.githubusercontent.com/47964708/154247950-dd373f81-4d31-4948-b50f-b87991be170c.png)  
    ![SmartSelectImage_2022-02-16-19-38-58](https://user-images.githubusercontent.com/47964708/154247953-a094f485-d7ad-409b-873c-8e151226472d.png)  
