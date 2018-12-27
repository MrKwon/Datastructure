package com.doit.chapter02;

import java.util.Scanner;

public class Array {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static int[] reverse(int[] a) {
        for(int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }

        return a;
    }

    static boolean equals(int[] a, int[] b) {
        if(a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;

        return true;
    }

    static int[] copy(int[] b) {
        int[] a;
        a = b.clone();

        return a;
    }

    static int[] rcopy(int[] b) {
        int[] a;
        a = reverse(b);

        return a;
    }

    static void printArr(int[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.println("행렬 원소 [" + i + "] = " + a[i]);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Array \"a\" element nums : ");
        int na = stdIn.nextInt();
        int[] a = new int[na];

        for (int i = 0; i < na; i++) {
            System.out.println("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        a = reverse(a);

        System.out.println("요소를 역순으로 정렬했습니다.");
        printArr(a);

        System.out.print("Array \"b\" element nums : ");
        int nb = stdIn.nextInt();
        int[] b = new int[nb];

        for (int i = 0; i < na; i++) {
            System.out.println("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        System.out.println("배열 a와 b는" + (equals(a, b) ? "같음" : "다름"));

        int[] c = copy(b);
        printArr(c);
        int[] d = rcopy(c);
        printArr(d);
    }
}
