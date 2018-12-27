package com.doit.chapter02;

public class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0; // 나눗셈 횟수 counter
        int ptr = 0; // 소수 nums
        int[] prime = new int[500]; // 소수를 담기 위한 arr

        prime[ptr++] = 2; // 2는 소수임, prime[0]에 2를 넣고 ptr++ 수행

        for (int n = 3; n <= 1000; n += 2) { // n은 3부터 1000까지 홀수에 대하여 소수인지 아닌지 검사, 짝수는 소수가 있을 수 없음
            int i;
            for (i = 1; i < ptr; i++) {
                counter++;
                if (n % prime[i] == 0)
                    break;
            }
            if (ptr == i)
                prime[ptr++] = n;
        }

        for (int i = 0; i < ptr; i++)
            System.out.println(prime[i]);

        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }
}
