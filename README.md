# java-ladder
2022 마스터즈 백엔드 사다리 게임 프로젝트

## Step 1: 기본 기능 구현

### 동작 방식
0. Application에서 `LadderGameManager.init()을 통해 실행합니다.
1. init() 내부의 inputNumber()를 통해 필요한 정보를 입력받습니다.
2. 입력받은 정보를 통해 Ladder 객체를 만들고 Ladder의 생성자에서 2차원 배열 형태의 사다리를 만듭니다.
3. LadderGameManager.showLadder()를 통해 사다리 정보를 출력합니다.

## Step 2: 리팩토링 맛보기

### 리팩토링 내용
0. 메서드의 크기가 너무 커지지않도록 함수 내부 로직을 분리하려고 하였습니다.
1. 들여쓰기 depth, else 사용 등을 피하기 위해 메서드를 분리하였습니다. 