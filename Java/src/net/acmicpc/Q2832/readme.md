```
reverse-sort(sequence a)
    while (A is not in nondecreasing order)
        partition a into the minimum number of slopes
        for every slope with length greater than one
            reverse(slope)
```

여기서 slope란 감소하는 a의 연속 부분 수열이다.
reverse는 그 구간의 순서를 뒤집는다.

1부터 N으로 이루어진 길이가 N인 순열이 주어진다.
처음에 순열의 slope의 길이는 모두 짝수이다.
reverse를 몇 번 호출하는지 구하는 프로그램을 작성하시오.