# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능요구사항
* 주어진 횟수 동안 n대의 
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다.
* 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
* 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.

## 구현 기능 목록
### [Model]
#### 자동차 이름
* [X] 이름값을 검증한다.
  * [X] 값이 비었거나 Null인지 검사.
  * [X] 이름의 길이가 1~5글자 사이인지 검사.
#### 자동차 이름 모음
* [X] 사용자가 입력한 이름값을 검증한다.
  * [X] 중복된 이름이 있는지 검사.
  * [X] 이름이 두개 이상인지 검사.
* [X] 쉼표(,)를 기준으로 파싱하여 List<Name>으로 변환한다.
#### 자동차 거리
* [X] 거리를 지정한 값으로 증가시킨다.
* [X] 거리 간 비교를 위한 메서드를 구현한다.
#### 이동전략
* [X] 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 true, 3 이하의 값이면 false를 반환한다.
#### 자동차
* [ ] 자동차 이름과 자동차 거리를 매개변수로 가지는 자동차 클래스를 구현한다.
* [ ] 주입받은 이동전략으로 자동차를 이동시킨다.
* [ ] 더 빠른 자동차를 찾는다.
  * [ ] 두 자동차의 거리를 비교한다.
#### 자동차 모음
* [ ] 자동차 이름 모음으로 자동차들을 생성한다.
* [ ] 주입받은 이동전략으로 자동차들을 이동시킨다.
* [ ] 가장 빠른 자동차들을 찾는다.
  * [ ] 가장 빠른 자동차를 찾는다.
  * [ ] 가장 빠른 자동차와 거리가 같은 자동차들을 찾는다.
#### 라운드
* [ ] 자동차 모음과 이동전략을 매개변수로 가지는 자동차 클래스를 구현한다.
* [ ] 라운드를 시작한다. 시작하면 이동된 자동차 모음으로 생성된 라운드를 반환한다.
* [ ] 자동차 모음의 메서드를 이용해 가장 빠른 자동차들을 찾는다.
#### 시도횟수
* [ ] 사용자가 입력한 시도횟수를 검증한다. - 시도횟수가 1 미만인지 검사.
* [ ] 특정 숫자보다 작은지 비교한다.
#### 레이싱게임
* [ ] 자동차모음, 시도횟수, 이동전략을 매개변수로 가지는 자동차 클래스를 구현한다.
* [ ] 시도횟수만큼 진행시킨 라운드들을 진행시키고 List<Round>에 저장한다.
* [ ] 마지막 라운드에서 우승한 자동차들을 찾는다.

### [Controller & View]
* [ ] 어플리케이션 컨트롤러와 UI단을 구현한다.
