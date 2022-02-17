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