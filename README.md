# java-ladder
2022 마스터즈 백엔드 사다리 게임 프로젝트

## STEP1

### 기능 요구사항

- [x] n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- [x] 사다리의 라인은 랜덤 생성.  
  ㄴ ("-") 혹은 (" ")

### 프로그래밍 요구사항

- [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현
- [x] 메서드가 한 가지 일만 하도록 작게 분리

## STEP2

- [x] 들여쓰기 depth를 2단계에서 1단계로 줄이기
- [x] else를 사용하지 않기
- [x] 무의미한 enum 사용 없애기  
  ㄴ 1단계에서 구현한 Message를 enum으로 만들어 얻을 수 있는 장점은, 상수로 선언한 message 문자열을 단순히 한 곳에 몰아 넣은 것 말곤 다른 장점이 없다. 또, enum은 관련이 있는 상수들의 집합을 묶을 때 사용하는데, message의 각각 내용들이 딱히 관련이 있는 것도 아니다.


- enum을 사용함으로 얻을 수 있는 장점은
  1. 허용 가능한 값들을 제한하여 타입 안전성을 보장하는 것
  2. enum을 사용하면 문맥을 담을 수 있는 점. A라는 상황에서 "first"와 B라는 상황에서 "first"는 똑같은 문자열 "first"지만 다른 의미로 사용된다.
     이를 String 으로 표현하면 다른 것을 표현할 수 없지만, Enum은 이를 표현할 수 있게 해준다. (객체의 주소값으로 관리하기 때문) 이로 인해 코드를 이해하기 위해 무언가를 찾아보는 행위를 최소화 할 수 있게 해주는 것.
     
### 구현

```java
    private String initLadderLow(int LadderLine) {
        StringBuilder sb = new StringBuilder();

        // 열이 짝수라면 "|", 홀수라면 " " or "-" 입력
        for (int i = 0; i < LadderLine; i++) {
            if (i % 2 == 0) {
                sb.append("|");
                continue;
            }
            sb.append(initRandomLine());
        }
        return sb.toString();
    }
```

initLadderRow() 메서드의 for문에서 수행하던 로직을 홀수와 짝수를 구분하고, 들어갈 사다리의 모양을 넣어주는 기능 2가지로 세분화 했다.

```java
    private String initLadderRow(int ladderLine) {
        StringBuilder sb = new StringBuilder();

        // 열이 짝수라면 "|", 홀수라면 " " or "-" 입력
        IntStream.range(0, ladderLine).forEach(line -> determineLineShape(line, sb));
        return sb.toString();
    }

    private StringBuilder determineLineShape(int line, StringBuilder sb) {
        if (validateEven(line)) {
            return sb.append("|");
        }
        return sb.append(initRandomLine());
    }

    private boolean validateEven(int number) {
        return number % 2 == 0;
    }
```

initLadderRow()는 Row를 생성하기 위한 사전 작업을 하고, 필요한 준비물을 determineLineShape() 메서드로 전달한다.  
determineLineShape()는 전달받은 StringBuilder 객체에 값을 넣어준다. 이 때 전달받은 line이 홀수인지, 짝수인지 판단하는 것은 validateEven() 메서드에 맡긴다.

```java
public enum Message {
    NUBER_OF_PEOPLE("참여할 사람은 몇 명인가요?"),
    DEPTH_OF_LADDER("최대 사다리 높이는 몇 개인가요?");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
```

enum class Message를 삭제하고, 해당 문자열을 상수로 선언하여 사용할 지, 문자열로 바로 전달하는게 좋을 지 고민했다.

"참여할 사람은 몇 명인가요?", "최대 사다리 높이는 몇 개인가요?"는 인원수와, 사다리 높이를 입력받는 메서드에서 출력 객체에 전달해줄 때 한 번 사용될 뿐, 다른 곳에서 재사용 될 일이 없는 문자열이라고 생각되어 상수 선언하지 않고, 바로 문자열로 전달해주는 방식으로 바꾸었다.

## STEP3

### 기능 요구 사항

- [ ] 배열 대신 ArrayList와 Generic을 활용해 구현한다.


- [x] 사다리 게임에 참여하는 플레이어의 이름은 최대 5글자까지 가능하다.  
  ㄴ 이름을 입력받는 처리, 검증 처리 필요  
  ㄴ 입력받는 플레이어의 이름은 쉼표(,)를 기준으로 구분한다.
- [ ] 사다리 출력 시 사용자의 이름도 같이 출력한다.
- [ ] 플레이어의 이름이 최대 5글자까지 가능하기에 사다리의 폭도 넓어져야 한다.
- [ ] 사다리가 분기를 결정할 수 있도록 가로 라인이 왼쪽, 오른쪽 동시에 존재하지 않게 처리해야 한다.  
  ㄴ `|-----|-----|` 모양과 같은 형태가 되지 않게끔.
  
### 구현

- Ladder클래스의 2차원 배열 ladder를 list로 변경. Generic 활용법은 아직 찾지 못함
- 참여할 플레이어의 인원 수를 입력받던 부분을 삭제하고 플레이어의 이름 목록을 문자열로 입력 받은 후 처리를 구현한다.
