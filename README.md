# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 목록
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  - [x] 로또 구입 금액을 입력할 수 있다. (로또 1장의 가격은 1000원이다.)
  - [x] 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발급할 수 있다.
  - [x] 로또의 숫자는 1 ~ 45 사이의 자연수이다.
  - [x] 로또 한 장은 중복되지 않은 6개의 숫자를 갖는다. (오름차순 정렬로 출력한다.)
- [x] 지난 주 당첨 번호를 입력할 수 있다. (콤마 기준으로 나눠진 6개의 숫자)
- [x] 당첨 통계를 낼 수 있다.
  - [x] 4, 3, 2, 1등 순서(3개, 4개, 5개, 6개)로 각각 몇 개의 로또가 해당되는지 구할 수 있다.
  - [x] 상금과 구입 금액으로 총 수익률을 구할 수 있다.

<hr>

# 문자열사칙연산계산기
## 기능 목록

- 문자열을 입력할 수 있다.
    - 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- 입력 문자열의 숫자와 사칙 연산 사이에는 **반드시 빈 공백 문자열**이 있다고 가정한다.
    - 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
    - split해서 생성된 리스트의 길이는 반드시 홀수여야 한다.
- 사칙연산을 할 수 있다.
    - 덧셈
    - 뺄셈
    - 곱셈
    - 나눗셈
- **나눗셈의 경우 결과 값을 정수**로 떨어지는 값으로 한정한다.
- 문자열 계산기는 **사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정**된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    - 예를 들어 **`2 + 3 * 4 / 2`**와 같은 문자열을 입력할 경우 **`2 + 3 * 4 / 2`** 실행 결과인 10을 출력해야 한다.


## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
