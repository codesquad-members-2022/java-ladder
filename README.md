# java-ladder
2022 마스터즈 백엔드 사다리 게임 프로젝트

## 1단계

### 구조 만들기

- Main</br>
- domain</br>
    - Board</br>
    - Line</br>
- view</br>
    - InputView</br>
    - OutputView</br>
- Util</br>
    - Vaild</br>

## 2단계

- 입력값(데이터)의 검증은 어디서, 얼마나 해야할까? (프로그램에서는 확실한 검증과 동시에 기능에 맞춰서 검증을 여러차례 한다고 들었다.)
- 검증 역할을 어디에서 해야하며, 검증하는 방법은 어떤것이 가장 좋을까?
- 이번 과제와 관련하여서는 객체의 생성자에 검증 메서드가 들어가는게 맞는지 검증을 해서 파라미터로 넣어주는 방법이 맞는건지 모르겠다. 
```java
// 검증만
public static void checkPlayers(int count) {
        if(count < MIN_PLAYER) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
    }

    public static void checkHegiht(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }
```

```java
// 검증 후 반환
public static int checkPlayersReturn(int count) {
        if(count < MIN_PLAYER) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
        return count;
    }

    public static int checkHeightReturn(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSGAE);
        }
        return height;
    }
```

```java
    // void로 검증
    public Board(int players, int height) {
        Valid.checkPlayers(players);
        Valid.checkHegiht(height);
        frame = new String[height][(players*2)-1];
        line = new Line();
    }
    // 검증 후 반환
    public Board(int players, int height) {
        this.players = Valid.checkPlayersReturn(players);
        this.height = Valid.checkHeightReturn(height);
        frame = new String[this.height][(this.players*2)-1];
        line = new Line();
    }
```

## 3단계

- [x] 플레이어의 이름은 최대 5글자
- 임의로 이름을 알파벳과 숫자로만 가능하도록 했고, 인원수를 2명에서 10명으로 제한하였음

- [x] 사다리 출력시 이름도 같이 출력
- Names 클래스를 생성해서 toString()으로 구현

- [x] 사람 이름은 쉼표(,)를 기준으로 구분
- 정규식을 적용해서 검증하고, split메서드를 통해서 가지고 있도록 하였음

- [x] 사다리폭 확장
- String.format을 활용해서 구현

- [x] 사다리 라인 겹치지 않도록 구현
- 랜덤 생성전 옆 칸을 확인하도록해서 겹치지 않도록 구현

- [x] 2차원 배열 대신 ArrayList사용

## 4단계

###리팩토링 생각해보기

* 힌트와 같이 frame을 List<List<String>>으로 가지고 있는게 아니라, floor라는 객체?일급컬렉션?으로 만드는 것으로 수정해보기
* Board는 Line이라는 객체를 가지고서 사다라에 라인을 랜덤으로 생성하는 역할을 한다. 하지만 이 역할이 단순히 Board 객체가 가지고 있어도 되는 것 같다.
  * floor객체를 만들면서 Line의 역할까지 floor에서 하는 것으로 리팩토링 해봐야겠다.
* 사다리는 출력예시와 같이 출력만 하면 된다. 굳이 출력전에 String으로 값을 가지고 있을 이유도 없다. 그래서 힌트와 같이 Boolean 타입으로 가지고 있는 방법도 고려해야겠다.
* 3차 PR에서 질문했던 InputView에서 입력을 받아서 검증하고 도메인 객체로 반환하는 방식으로 리팩토링 시도해보기