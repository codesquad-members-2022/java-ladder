# java-randomLadder
2022 마스터즈 백엔드 사다리 게임 프로젝트

## 요구사항
- [x] 사다리 실행 결과를 출력해야 한다.
- [ ] 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
- [ ] 이름에 "춘식이"를 입력하면 프로그램을 종료한다.
- [x] setter 메소드를 사용하지 않고 구현한다.
- [x] 단, DTO(Data Transfer Object)는 setter를 사용해도 무방하다.

## Dion이 리뷰해주신 부분
- [ ] 코드 포매팅 신경쓰기
- [ ] Controller에서 사용자 요청 받도록 하는 메서드의 위치 생각해보기
- [x] 에러 출력은 System.out.error로 변경해주기
- [ ] Ladder에서 depth 2가 지켜지지 않은 부분 해결하기 (55~58 라인)
- [x] makeStartPositions() 접근 제어자 수정하기
- [x] Line에서의 뷰 출력 수정하기
- [x] 상수 사용 부분 수정하기
- [x] Validation 하는 부분에서 예외 던지기
- [ ] @ParameterizedTest를 사용하기

## Step 5 TO-DO list
- [x] 사다리 로직 생각하기.
시작지점이 0 => 좌, 우 이동불가 => 바로 다음 라인으로 이동 (시작지점 0, 종료지점 0)
시작지점이 1 => 좌, 우 이동가능
  -> (좌로이동) 시작좌표-1
  -> (우로이동) 시작좌표+1

- [x] 사다리가 여러줄 일경우 생각하기
  -> 라인마다 실행하여 결과를 반환 -> 반환받은 결과를 다음 라인에 다시 적용 -> 끝에 도달하면 그 값 반환

- [x] 사다리에 라인을 표시할때 데이터로 의미표현해보기
  -> 1이 저장되어 있으면 1 -> 2 오른쪽으로 이동해야 함
  -> 2가 저장되어 있으면 1 <- 2 왼쪽으로 이동해야 함.
```java
columns[startPosition] = 1;
columns[startPosition + 1] = 2;
```

- [x] direction 상수값 enum으로 추출하기
- [x] 공통부분 interface로 추출하기
- [x] 팩토리 클래스 만들기


## Step 3~4 TO-DO list
- [x] 사다리의 여러 행 중 하나인 Line 클래스 만들기
- [x] Line 자체적으로 draw() 메서드 만들기
- [x] Line을 여러행 갖는 Ladder 클래스 만들기
- [x] 사용자의 입력을 타입화 한 LadderSize class 만들기


- [x] Ladder안의 각 Lines들의 랜덤한 다리 생성하기
- -[x] Line 초기화 하기
- -[x] Random하게 선을 그을 시작 점 생성
- - -[x] random한 포지션들 구하기
- - -[x] random int값을 좌표값으로 변경기
- -[x] 시작점을 통해 선 생성


- [x] random Position들을 만들떄 구현할점
- -[x] 시작위치가 이미 존재하면 안됨
- -[x] 시작위치-1 한 값도 존재하면 안됨


- [x] Position 만들기
- [x] 주어진 Ladder를 출력하는 outputView 만들기
- [x] 사용자의 입력을 받는 inputView 만들기
