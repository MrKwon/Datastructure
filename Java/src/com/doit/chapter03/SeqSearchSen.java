package com.doit.chapter03;

import java.util.Scanner;

public class SeqSearchSen {
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

//        while(true) {
//            if (a[i] == key)
//                break;
//            i++;
//        }
        for ( ; i < n; i++)
            if (a[i] == key)
                break;

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; // sentinel 을 위한 요소를 추가하기 위해 요소 수 + 1

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값");
        int key = stdIn.nextInt();

        int index = seqSearchSen(x, num, key);

        if (index == -1)
            System.out.println("그 값은 요소가 없습니다.");
        else
            System.out.println(key + "는 x[" + index + "]에 있습니다.");
    }
}
