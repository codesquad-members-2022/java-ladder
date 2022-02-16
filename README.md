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

