# 2022 마스터즈 백엔드 사다리 게임 프로젝트

## 사다리 게임 1단계 - 기본 기능 구현

### 기능요구사항
* [x] 간단한 사다리 게임을 구현한다.
* [x] n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
* [x] 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
* [x] 사다리가 있으면 -를 표시하고 없으면 " " (공백문자)를 표시한다. 양옆에는 |로 세로를 표시한다.
* [x] 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 프로그래밍 요구사항
* [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* [x] 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
* [x] 2차원 배열을 학습하고 이를 이용해서 문제를 해결한다.

### 프로젝트 구조
```shell
.
├── README.md
└── src
    └── dukcode
        ├── Main.java
        ├── controller
        │   └── LadderController.java
        ├── model
        │   └── Ladder.java
        └── view
            ├── PrintView.java
            └── ScanView.java
```
### 구현
#### 1. 전체적인 프로세스
* `ScanView`에 `Scanner`를 주입해 생성하고 입력을 처리해 결과를 `LadderController`에 넘겨준다.
* `LadderController`에서 `Ladder`를 초기화 하고 결과를 `PrintView`에 넘겨 결과를 출력하도록 한다.
```java
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScanView scanView = new ScanView(sc);
        Ladder ladder = new Ladder();
        PrintView printView = new PrintView(ladder);
        LadderController ladderController = new LadderController(printView, ladder);

        ladderController.initLadder(scanView.getNumPlayer(), scanView.getHeight());
        ladderController.updatePrintView();
        sc.close();
    }
}
* ```

#### 2. `Ladder.init()` 구현
* 클린한 코드를 위해 2중 `for`문을 피하는 코드를 작성했다. 따로 `line`을 초기화 하는 함수를 구현했다.
* `Ladder`의 2차원 배열은 steps(발판)만 있어도 되기 때문에 가로 축이 player의 수 보다 1 작게 만들었다.
```java
    public void init(int numPlayer, int height) {
        this.numPlayer = numPlayer;
        this.height = height;

        ladder = new boolean[height][numPlayer - 1];
        for (int line = 0; line < height; ++line) {
        initLine(line);
        }
    }

    private void initLine(int line) {
        Random rd = new Random();
        for (int step = 0; step < numPlayer - 1; ++step) {
        ladder[line][step] = rd.nextBoolean();
        }
    }
```
### 3. `Ladder.toString()` 구현
* `StringBuilder`를 사용해 `append()`하기 수월하게 구현하였다.
* 2중 `for`문을 피하기 위해 `line`에 대한 `String`을 받아오는 함수를 따로 구현하였다.
* 이 `String`정보를 `PrintView`에 넘겨 결과를 출력한다.
```java
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
        sb.append(getStringLine(line));
        sb.append("\n");
        }

        return new String(sb);
    }

    public String getStringLine(int line) {
        StringBuilder strLine = new StringBuilder("|");
        for (int step = 0; step < numPlayer -1; ++step) {
        strLine.append(ladder[line][step] ? "-" : " ");
        strLine.append("|");
        }

        return new String(strLine);
    }
```

### 실행 결과

![img.png](./readme_image/level_1_result.png)




## 사다리 게임 2단계 - 리팩토링 맛보기

### 기능요구사항
* [x] 1단계 요구사항과 동일함

### 프로그래밍 요구사항
* [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* [x] 메서드가 한 가지 일만 하도록 최대한 작게 만들어라.
* [x] 들여쓰기(indent) depth를 2단계에서 1단계로 줄여라.
* [x] depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
* [x] else를 사용하지 마라.
* [x] 구현 순서를 고려하면서 프로그래밍한다.
* [x] naming convention을 지키면서 프로그래밍한다.

### 리팩토링 과정

#### 1. 변수 인라인화
* `ScanView`의 `getNumPlayer()`메서드와 `getHeight()`메서드의 필요 없는 변수를 인라인화 시켰다.
```java
    public int getnumplayer() {
        system.out.println("참여할 사람은 몇 명인가요?");
        int numplayer = sc.nextint();

        return numplayer;
        }
        
// -->        

public int getHeight() {
        System.out.println("최대 사다리 높이 는 몇 개 인가요?");
        return sc.nextInt();
        }
```

#### 2. 어노테이션 추가
* 'Ladder'클래스의 `toString()`메서드에 어노테이션을 추가했다.
```java
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
            sb.append(getStringLine(line));
            sb.append("\n");
        }

        return new String(sb);
        }
* ```





## 사다리 게임 3단계 - 사다리 모양 개선
## 사다리 게임 4단계 - 리팩토링 2
## 사다리 게임 5단계 - 실행 결과 출력
