# java-ladder
2022 마스터즈 백엔드 사다리 게임 프로젝트



### 기능요구사항
- [ ] 간단한 사다리 게임을 구현한다.
- [ ] n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- [ ] 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- [ ] 사다리가 있으면 -를 표시하고 없으면 " " (공백문자)를 표시한다. 양옆에는 |로 세로를 표시한다.
- [ ] 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.


### 프로그래밍 요구사항
- [ ] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [ ] 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
- [ ] 2차원 배열을 학습하고 이를 이용해서 문제를 해결한다.


#### 비즈니스 로직
- n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
    - 최소 2명, 사다리 높이는 `인원수-1` 이상을 입력 받는다.
    - 또는 사다리 높이 1인 경우이더라도, 2명 이상이면, 시작지점을 랜덤으로 출발항 결과값을 예측할 수 없도록 한다.


- 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
    - 인원수의 범위내에서 random 값에 따라 사다리의 위치값이 나온다.
    - 시작위치에서 다음 random 값이 나오면 해당 값 만큼 '-'를 표시


- 사다리가 있으면 -를 표시하고 없으면 " " (공백문자)를 표시한다. 양옆에는 |로 세로를 표시한다.


- 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.


#### 결과
- 입력값 범위 검증 

<img src="https://user-images.githubusercontent.com/96989782/153838599-32e43d5e-9476-4a30-8edf-65b3a7038b2f.PNG" width="300">


