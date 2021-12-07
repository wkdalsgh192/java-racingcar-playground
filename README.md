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
> 예외 처리
> - 커스텀 구분자가 아닌 예외 구분자 사용했을 때 Runtime Exception
> - 음수를 전달하는 경우 Runtime Exception