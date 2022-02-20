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

## 4단계

### 리팩토링 생각해보기

- [x] 힌트와 같이 frame을 List<List<String>>으로 가지고 있는게 아니라, floor라는 객체?일급컬렉션?으로 만드는 것으로 수정해보기
- [x] Board는 Line이라는 객체를 가지고서 사다라에 라인을 랜덤으로 생성하는 역할을 한다. 하지만 이 역할이 단순히 Board 객체가 가지고 있어도 되는 것 같다.
  * floor객체를 만들면서 Line의 역할까지 floor에서 하는 것으로 리팩토링하기 
- [ ] 사다리는 출력예시와 같이 출력만 하면 된다. 굳이 출력전에 String으로 값을 가지고 있을 이유도 없다. 그래서 힌트와 같이 Boolean 타입으로 가지고 있는 방법도 고려하기
- [x] 3차 PR에서 질문했던 InputView에서 입력을 받아서 검증하고 도메인 객체로 반환하는 방식으로 리팩토링 시도해보기

### 의문점과 더 고민할 점
* InputView 메서드를 하나로 묶으면서 Names객체를 외부에서 사용할 수 없어졌다. 그에 따라서 Ladder의 toString() 메서드내에 Names() toStirng()을 담게 되었다. 
  * -> Board가 Names를 갖게되면서, 클래스명을 Board에서 Ladder로 수정하게 되었다. 이렇게 리팩토링 한것이 조금 더 리팩토링의 유연함을 빼앗아간 건지도 모르겠다.

* List이 제네릭 즉, Floor에 담기는 타입에 대해 고민을 많이했다.
  * LINE과 BlANK 두 가지만을 고려한다면 Boolean으로 담는것이 가장 효율적이다. 그리고 출력을 하려고 했을때, 출력을 담당하는 OutputView에서 Board와 floor의 내부 리스트에 접근할 수 있다면 출력할 수 있다.
  * 하지만 캡슐화의 관점에서 본다면, private으로 선언한 내부 변수에 getter를 통해서 접근하도록 하는 것은 옳지 않은 것 같다.(객체의 책임과 역할)
  * 타입을 Boolean으로 가지고 있고, 지금과 같이 floor와 Board에 선언된 상수를 조금 수정한뒤 그 상수로 변환하도록해서 (toString()방식처럼) 가져오는건 어떨까?
  * 내부 변수를 getter로 가져오지는 않고서, 메서드를 만들어서 각 List의 위치를 찾아서 값을 확인하는 방법으로 구현해보자.

### TODO
* 플레이어의 이름도 Name으로 감싸기 (name 다섯글자 이상일시 ..으로 바꾸는 메서드)
* Ladder 객체내의 Board도 따로 객체로 만들기
* 출력을 toString() 방식으로 계속 구현했으니, Boolean타입으로 바꾸고 OutputView에서 출력하도록 리팩토링 하기
* 테스트코드 작성하기

## 5단계
* PR 리뷰 내용 리팩토링하기
  - [ ] toString으로 출력하는 것, 그리고 도메인 객체에서 출력을 담당하는 것을 분리하기
  - [ ] 생성자는 생성만 할 수 있게끔 처리하기
  - [ ] 테스트가 가능하도록 Random으로 처리하는 메서드와 분리하기

