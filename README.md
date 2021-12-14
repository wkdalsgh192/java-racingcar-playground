## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
## 문자열 덧셈 계산기 요구사항
1. 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환
2. 커스텀 구분자 지정 가능. 문자열 "//"와 "\n" 사이에 위치하는 문자 -> 커스텀 구분자 
3. 숫자 외의 값 또는 음수를 전달하는 경우 Runtime Exception 예외를 던진다.
> 테스트 가능한 영역 분리
> - 빈 문자열 또는 null이 들어왔을 때 0을 반환("" | null)
> - 숫자 하나만 들어왔을 때 해당 숫자를 반환 ("1" | "10")
> - 기본 구분자에 대해 분리해 합했을 때 모두 더한 값 반환 ("1,2,3" | "3:4:5")
> - 커스텀 구분자를 사용핼을 때 파싱해서 값을 더하기 ("//;\n1,2,4")
> - 커스텀 구분자가 아닌 예외 구분자 사용했을 때 Runtime Exception
> - 음수를 전달하는 경우 Runtime Exception

## 레이싱 경주 요구사항
1. 자동차에 이름을 부여할 때 5자를 초과할 수 없다.
2. 자동차를 출력할 때 이름을 보여주어야 한다.
3. 자동차 이름이 주어질 때 쉼표를 기준으로 차를 구분한다.
4. 자동차 경주 게임을 완료한 뒤 우승자를 알 수 있다. 우승자는 한 명 이상이다.
5. <span style="color: red"> 자동차가 이동하는 조건은 랜덤하게 구해진 값이 4이상인 경우이다. </span>

### 자동차
> - 자동차를 출력할 때 이름을 표시 {"pobi" -> car.getName() == "pobi"}
> - 자동차 이름이 5자를 넘으면 예외가 발생한다. { "pobipobi" -> throw new IllegarArgumentException } 
> - 여러 대의 자동차 이름이 주어질 때 쉼표를 기준으로 차가 만들어 진다. {"pobi,crong,honux" -> List<Car> size == 3 }
> - !! 쉼표가 아닌 다른 구분자가 들어오면 예외를 발생시킨다.

### 자동차 경주
> - 각각의 자동차가 정해진 횟수동안 몇 번 움직였는 지 안다면, 우승자를 반환한다. {(3,5,4) -> racing.getResult.size() == 1}
> - !! 자동차의 수와 움직인 수가 다르면 예외를 발생시킨다.
> - !! 정해진 횟수동안 모두 0번 움직였다면 아직 게임이 시작되지 않은 것이다.

## 레이싱 경주 피드백 반영할 부분
1. Position 변수를 만들고, 자동차가 랜덤하게 이동하는 로직 개선
2. Equals를 이용해 객체끼리 비교하기

### 피드백 진행과정에 염두할 부분
1. 테스트 가능한 코드(핵심 로직)와 어려운 코드(UI 로직)를 분리한다. => 핵심 로직에 테스트하기 어려운 코드는 어떻게 테스트하기 쉬운 코드로 바꿀 지 고민한다.
2. 모든 원시값과 문자열을 포장한다. => 객체끼리 비교한다.
3. 일급 컬렉션을 쓴다.

### 자동차
> - 자동차 이름은 5자를 초과할 수 없다.
> - 전진하는 자동차를 출력할 때, 위치와 이름을 함께 출력한다.
> - 자동차가 이동하는 조건은 랜덤하게 구해진 값이 4 이상인 경우이다. { car.move() -> if RAND > 4, position++ }
> - 자동차 이름은 쉼표를 기준으로 구분한다.

### 자동차들 & 레이싱 경주
> - !! 자동차 전진 조건이 랜덤값에 의존적이라면 어떻게 레이싱 결과를 알 수 있을까?
> - 우승한 자동차들의 생성 인스턴스와 결과 인스턴스는 같다. { input.equals(output) == true }