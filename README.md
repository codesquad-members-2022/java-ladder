# java-ladder
2022 마스터즈 백엔드 사다리 게임 프로젝트

## 요구사항
- [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
- [x] else를 사용하지 마라.
- [x] 배열 대신 ArrayList와 Generic을 활용해 구현한다.
- [x] 로직을 구현하는 코드에 단위 테스트가 존재해야 한다. 단, UI 처리 로직(System.in, System.out)은 테스트에서 제외한다.
- [x] 각각의 역할에 맞도록 패키지를 분리하고 접근 제어자를 적절히 사용하도록 리팩토링한다.

## 호눅스가 수정하라 권고해 주신부분
- [x] 파일 맨 마지막에 EOF라인 추가하기
- [ ] LaddserSize 이름 변경하기

## TO-DO list
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
