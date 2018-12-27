package com.doit.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int index = Arrays.binarySearch(x, key);

        if (index < 0)
            System.out.println("그 값의 삽입 포인트(index)는 : " + Math.abs(index + 1) + " 입니다");
        else
            System.out.println(key + "는 x[" + index + "] 에 있습니다.");
    }
}
