package com.doit.chapter05;

import com.doit.chapter04.IntStack;

import java.util.Scanner;

public class RemoveRecur02 {
    static void recur(int n) {
        IntStack stack = new IntStack(n);

        while (true) {
            if (n > 0) {
                stack.push(n);
                n = n - 1;
                continue; // while 문의 첫 줄로 돌아감
            }
            if (!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n = n - 2;
                continue; // while 문의 첫 줄로 돌아감
            }
            break; // n > 0 이 아님 && stack 이 Empty 이면 실행됨
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
