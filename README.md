# 사다리 게임 🕹

2022 마스터즈 백엔드 사다리 게임 프로젝트  

---

# Step1 : 기본 기능 구현
간단한 사다리 게임을 구현합니다.  

<details>
<summary> 🖼📝 Step 1 결과와 설명 </summary>
<div markdown="1">

#### 결과

```text
참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개인가요?
5
|-| |
| |-|
| |-|
| |-|
| | |
```

0. GameController.run() 메서드에서 시작됩니다.
1. InputView에서 사용자 입력을 받습니다.
2. 입력받은 값을 가지고 Ladder 객체를 생성합니다.
3. Ladder 객체 생성 후 Ladder.drawRandomLines() 메서드를 통해 Ladder.lines(사다리 데이터)에 랜덤하게 다리를 그려줍니다.
4. OutputView에 Ladder에서 랜덤하게 생성한 lines를 넘겨받아 사용자가 보기 편한 형태로 출력합니다.

---

- GameController.run() 메서드에서 게임이 시작됩니다.

```java
public class GameController {
    private static void run() {
        // 1. 사용자 입력
        int playerCount = InputView.getInputNumer("참여할 사람은 몇 명인가요?");
        int ladderMaxHeight = InputView.getInputNumer("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = Ladder.create(playerCount, ladderMaxHeight); // 2. Ladder 객체 생성
        ladder.drawRandomLines(); // 3. 사다리 그리기

        // 4. 사용자 출력
        OutputView.print(ladder.getLines());
        
        InputView.close();
    }
}

```


1. InputView에서 사용자 입력을 받습니다.
   InputView.getInputNumber(message) 메서드를 통해 사용자에게 입력을 받습니다.  
   모든 프로그램이 끝난 후 마지막으로 InputView.close()를 통해 표준 입력을 닫습니다.

```java
public class GameController {
    private static void run() {
        // 1.
        int playerCount = InputView.getInputNumer("참여할 사람은 몇 명인가요?");
        int ladderMaxHeight = InputView.getInputNumer("최대 사다리 높이는 몇 개인가요?");

        // 중략
        
        InputView.close();
    }
}

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInputNumer(String message) {
        OutputView.printMessage(message);
        int result = Integer.parseInt(scanner.nextLine());
        return result;
    }

    public static void close() {
        scanner.close();
    }
}


```
2. 입력받은 값을 가지고 Ladder 객체를 생성합니다.

```java

public class GameController {
    private static void run() {
        Ladder ladder = Ladder.create(playerCount, ladderMaxHeight); // 2.
        ladder.drawRandomLines(); // 3.
    }
}

public class Ladder {
    // 생략
    public static Ladder create(int playerCount, int ladderMaxHeight) {
        Ladder ladder = new Ladder();
        ladder.playerCount = playerCount;
        ladder.ladderMaxHeight = ladderMaxHeight;
        ladder.lines = new int[ladderMaxHeight][playerCount];
        return ladder;
    }
}

```

3. Ladder 객체 생성 후 Ladder.drawRandomLines() 메서드를 통해 Ladder.lines(사다리 데이터)에 랜덤하게 다리를 그려줍니다.
   int[][] lines의 데이터 형식 예
   000   
   110  
   000  
   의 데이터라면 사용자가 이해하는 사다리는 다음과 같습니다.
   | | |  
   |-| |  
   | | |

1이 연속되어 있다면 사다리 간 연결 O  
0이라면 사다리 간 연결 X

```java

public class GameController {
    private static void run() {
        // 생략
        Ladder ladder = Ladder.create(playerCount, ladderMaxHeight); // 2.
        ladder.drawRandomLines(); // 3.
    }
}


public class Ladder {

    public void drawRandomLines() {
        int row = ladderMaxHeight;
        int col = playerCount;

        for (int row_i = 0; row_i < row; row_i++) {
            for (int col_i = 0; col_i < col - 1; col_i++) {
                if (isRandomDraw())
                    drawLine(row_i, col_i);
            }
        }
    }

    private boolean isRandomDraw() {
        return rnd.nextBoolean();
    }

    public void drawLine(int row, int col) {
        lines[row][col] = 1;
        lines[row][col + 1] = 1;
    }
}
```

4. OutputView에 Ladder의 int[][] lines를 넘겨받아 사용자가 보기 편한 형태로 출력합니다.

```java

public class GameController {
    private static void run() {
        // 생략

        // 4.
        OutputView.print(ladder.getLines());
    }
}
```

int[][] lines  
000     
110    
000

->  
사용자 출력    
| | |  
|-| |  
| | |

</div>
</details>

---

# Step2 : 리팩토링 맛보기

Step1의 코드를 리팩토링 합니다.


<details>
<summary> 📝 Step2 설명 </summary>
<div markdown="1">

- [x] 메서드 - 10라인 이하, 한 가지 일만
- [x] 들여쓰기 - depteh 1단계
- [x] else문 사용 금지

#### 1. Ladder
- drawRandomLines() 메서드 분할 -> (drawRandomLine() , drawRandomRadder())
- rename : drawLine -> drawRadder
- 멤버변수 rnd final으로 변경

#### 2. OutputView
- print(int[][] lines) 메서드 분할 -> (appendLine(), appendRadder())
- 사다리 그리는지 체크하는 조건문 추출 -> isRadder()
- private 생성자 생성으로 인스턴스 생성 방지

#### 3. InputView
- 멤버변수 scanner final으로 변경
- private 생성자 생성으로 인스턴스화 방지
- getInputNumber() 한 줄로 변경
- private 생성자 생성으로 인스턴스 생성 방지

#### 4.GameController
- fix : run 메서드 생성자 변경 : private -> public

</div>
</details>

---

# step3 : 사다리 모양 개선
step2의 코드의 사용자 View를 개선하고 내부 로직을 요구사항에 맞게 리팩토링 합니다.  

<details>
<summary> 🖼📝 Step 3 결과와 설명 </summary>
<div markdown="1">

#### 결과

![step3결과](https://i.imgur.com/xMKNlQS.jpg)

- [x] 사다리 게임에 참여하는 플레이어의 이름을 최대 5글자까지 부여할 수 있다.
- [x] 사다리 출력시 이름도 같이 출력한다.
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- [x] 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- [x] |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] method가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- [x] else를 사용하지 마라.
- [x] 배열 대신 ArrayList와 Generic을 활용해 구현한다.
- [x] 이름이 5글자 이상인 경우 앞 3글자, 나머지 .. 으로 표시 (e.g. Dawn McManus -> Daw..)
- [x] Utils 클래스를 따로 추출
- [x] 객체의 유효값 체크는 getter로 밖에서 체크하는 것이 아닌 객체 해당 안에서 체크하도록 함


</div>
</details>

---

# step4 : 리팩토링 2
step3의 코드를 리팩토링 합니다.

<details>
<summary> 🖼📝 Step 4 : 계층형 테스트(BDD 패턴) 결과와 간단한 코드 설명 </summary>
<div markdown="1">

- [x] 패키지 분리
- [x] 테스트 코드를 계층 구조(BDD 패턴) 으로 변경
- [x] StringUtils.center() 메서드의 리팩토링(분할과 가독성)
- [x] InputView에서 OutputView 메서드 사용하는 의존성 제거
- [x] 추가적인 예외처리

![LineTest](https://i.imgur.com/ekvzIjQ.jpg)

![StringUtilsTest](https://i.imgur.com/ppyjmWp.jpg)

계층형 테스트 코드는 이종립님의 [JUnit5로 계층 구조의 테스트 코드 작성하기](https://johngrib.github.io/wiki/junit5-nested/) 글을 참고하여 작성했습니다.   
Junit5에서 @Nested 어노테이션을 사용했고 `Describe - Context - It` 의 구조로 테스트 대상의 행동에 초점을 맞췄습니다.  

`Describe` - 설명할 테스트 대상 명시  
`Context` - 테스트 대상이 놓인 상황 설명
`It` - 테스트 대상의 행동을 설명

위 형태로 작성한 코드 일부분은 아래와 같다.  

```java

@DisplayName("Line 클래스")
class LineTest {

   @Nested
   @DisplayName("createLineWithPlayerCount 메소드는")
   class Describe_createLineWithPlayerCount {

      @Nested
      @DisplayName("만약 음수값이 주어진다면")
      class Context_with_negative {
         @Test
         @DisplayName("IllegalArgumentException 예외를 던진다.")
         void it_throws_a_exception() {
            assertThatThrownBy(() -> Line.createLineWithPlayerCount(-1))
                    .isInstanceOf(IllegalArgumentException.class);
         }
      }

      @Nested
      @DisplayName("만약 양수 n이 주어진다면")
      class Context_with_positive {
         @Test
         @DisplayName("주어진 n개의 point를 갖고, 사다리가 비어있는 Line 객체를 리턴한다.")
         void it_returns_a_vaild_line() {
            Line result = Line.createLineWithPlayerCount(3);

            assertThat(result.isLadder(0)).isFalse();
            assertThat(result.isLadder(1)).isFalse();
         }
      }
   }
   
   // 생략
}

```

</div>
</details>


---

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fku-kim%2Fjava-ladder&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)