package com.doit.chapter06;

import java.util.Scanner;

public class QuickSort {
    static void swap(int[] a, int index1, int index2) {
        int t = a[index1];
        a[index1] = a[index2];
        a[index2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        System.out.printf("a[%d] ~ a[%d] : {", left, right);
        for (int i = left; i < right; i++) {
            System.out.printf("%d, " ,a[i]);
        }
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (right > pl) quickSort(a, pl, right);
    }

//    static void quickSort(int[] a, int n) {
//        int pl = 0;
//        int pr = n - 1;
//        int x = a[n / 2];
//
//        System.out.printf("a[%d] ~ a[%d] : {", 0, n);
//        for (int i = 0; i < n - 1; i++) {
//            System.out.printf("%d, " ,a[i]);
//        }
//        System.out.printf("%d}\n", a[n - 1]);
//
//        do {
//            while (a[pl] < x) pl++;
//            while (a[pr] > x) pr--;
//            if (pl < pr)
//                swap(a, pl++, pr--);
//        } while (pl <= pr);
//
//        if (0 < pr) quickSort(a, pr);
//        if (n - 1 > pl) quickSort(a, pl);
//    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요소 수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

//        System.out.println("방법을 선택하세요 (0, 1) : ");
//        int select = stdIn.nextInt();
//        if (select == 0) {
        quickSort(x, 0, nx - 1);
//        } else if (select == 1) {
//            quickSort(x, nx);
//        }
        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
