package com.doit.chapter06;

import java.util.Scanner;

public class BubbleSort2 {
    static void swap(int[] a, int index1, int index2) {
        int t = a[index1];
        a[index1] = a[index2];
        a[index2] = t;
    }

    static int[] bubbleSort(int[] a, int n) {
        int[] arr = {0 , 0};
        for (int i = 0; i < n - 1; i++) {
            int exchange = 0;
            for (int j = n - 1; j > i; j--) {
                arr[0]++;
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    arr[1]++;
                    exchange++;
                }
            }
            if (exchange == 0) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전1)");
        System.out.print("요소 수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        int[] result = bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);

        System.out.println("비교를 " + result[0] + "회 했습니다.");
        System.out.println("교환을 " + result[1] + "회 했습니다.");
    }
}
