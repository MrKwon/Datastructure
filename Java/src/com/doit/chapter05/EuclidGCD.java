package com.doit.chapter05;

import java.util.Scanner;

public class EuclidGCD {
    static private int gcd(int x, int y) { // EuclidGCD 내에서만 접근하니까 private access modifier 달았음
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대 공약수를 구합니다.");
        System.out.print("정수를 입력하세요 : "); int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : "); int y = stdIn.nextInt();

        System.out.println("최대 공약수는 " + gcd(x, y) + " 입니다.");
    }
}
