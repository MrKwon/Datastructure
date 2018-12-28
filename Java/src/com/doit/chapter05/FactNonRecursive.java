package com.doit.chapter05;

import java.util.Scanner;

public class FactNonRecursive {

    static private int factorial(int n) {
        int[] arr;
        arr = new int[n];
        arr[0] = 1;
        for(int i = 1; i < n; i++) {
            arr[i] = i * arr[i - 1];
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int n = stdIn.nextInt();

        System.out.println(n + "의 팩토리얼은 " + factorial(n) + "입니다.");
    }
}
