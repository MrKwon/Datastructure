package com.doit.chapter05;

import java.util.Scanner;

public class Hanoi {
    static void move(int no, int x, int y) {
        if (no > 1) // 시작기둥 x 에서 중간기둥 6-x-y 로 이동
            move(no - 1, x, 6 - x - y); // 기둥 번호 1, 2, 3 합 6이므로 중간 기둥은 6 - x - y

        System.out.println("원반 [" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

        if (no > 1) // 중간기둥 6-x-y에서 끝기둥 y로 이동
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}
