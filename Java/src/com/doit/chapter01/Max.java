package com.doit.chapter01;

import java.util.Scanner;


class MinMax {
    static int max3(int a, int b, int c) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;

        return max;
    }

    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        if (b > max)
            max = d;

        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        if (b < min)
            min = d;

        return min;
    }
}

/**
 * 3개의 정수를 입력하고 최댓값을 구함
 */
public class Max {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값 : "); int a = stdIn.nextInt();
        System.out.println("b의 값 : "); int b = stdIn.nextInt();
        System.out.println("c의 값 : "); int c = stdIn.nextInt();

        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("최댓값은 " + max + "입니다. ");

        System.out.println(MinMax.max3(1, 2, 3));
        System.out.println(MinMax.max4(1, 3, 5, 7));
        System.out.println(MinMax.min3(1, 5, 9));
        System.out.println(MinMax.min4(2, 4, 6, 8));
    }
}
