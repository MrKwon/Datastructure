package com.doit.chapter03;

import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a, int n, int key) {
//        int i = 0;
//
//        while (true) {
//            if (i == n)
//                return -1;
//            if (a[i] == key)
//                return i;
//            i++;
//        }
        for (int i = 0; i < n; i++) {
            if (a[i] == key)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();
        int index = seqSearch(x, num, key);

        if (index == -1)
            System.out.println("그 값은 요소가 없습니다.");
        else
            System.out.println(key + "은(는) x[" + index + "]에 있습니다." );
    }
}
