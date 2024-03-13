### 1단계 - 문자열 계산기

```text
[기능 요구사항]
- 사용자 입력 문자열 값에 따라 사칙연산을 수행하는 계산기를 구현 
- 입력 문자열의 숫자와 사칙 연사 사이에는 반드시 "빈 공백 문자열"이 있다고 가정한다
- "나눗셈의 경우 결과 값을 정수"로 떨어지는 값으로 한정한다
- "사칙연산의 계산 우선 순위가 아닌 입력 값에 따라 계산 순선가 결정"된다
```

#### 기능 구현 목록

1. 유효성 검사

- [x] 입력 값이 null이거나 빈 공백 문자일 경우 -- IllegalArgumentException
- [x] 사칙연산 기호가 아닌 경우 -- IllegalArgumentException
- [x] 연산자의 개수는 (피연산자 - 1) 개수가 맞지 않은 경우 -- IllegalArgumentException
- [x] 연산자의 시작이 숫자가 아닌 경우 -- IllegalArgumentException

2. 사칙연산

- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈

