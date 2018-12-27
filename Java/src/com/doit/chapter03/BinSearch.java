package com.doit.chapter03;

import java.util.Scanner;

public class BinSearch {
    static int binSearch(int[] a, int n, int key) {
        int first = 0; // 검색범위 첫번째 인덱스
        int last = n - 1; // 검색범위 마지막 인덱스

        do {
            int mid = (first + last) / 2;
            if (a[mid] == key)
                return mid;
            else if (a[mid] < key)
                first = mid + 1;
            else
                last = mid - 1;
        } while (first <= last);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int index = binSearch(x, num, key);

        if (index == -1)
            System.out.println("그 값은 요소가 없습니다.");
        else
            System.out.println(key + "은 x[" + index + "]에 있습니다.");
    }
}
