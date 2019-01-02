package com.doit.chapter06;

import java.util.Scanner;

public class MergeArray {
    static void merge(int[] a, int[] b, int[] c) {
        int pa = 0;
        int pb = 0;
        int pc = 0;

        while (pa < a.length && pb < b.length)
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];

        while (pa < a.length)
            c[pc++] = a[pa++];

        while (pb < b.length)
            c[pc++] = b[pb++];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int[] a = { 2, 4, 6, 8, 11, 13};
        int[] b = { 1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[13];

        System.out.println("두 배열의 병합");
        merge(a, b, c);

        System.out.println("배열 a 와 배열 b 를 병합하여 배열 c 에 저장하였습니다.");
        System.out.println("배열 a :");

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }

        System.out.println("배열 b :");
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] = " + b[i]);
        }

        System.out.println("배열 c :");
        for (int i = 0; i < c.length; i++) {
            System.out.println("c[" + i + "] = " + c[i]);
        }

    }
}
