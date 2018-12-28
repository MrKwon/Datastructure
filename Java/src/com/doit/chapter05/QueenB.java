package com.doit.chapter05;


// 이것도 개오래 걸린다. 이거 경우의 수가 8^8 = 2^24 개인데 이게 그럼 약 8*10^6 개인데 겁나 오래 걸림
public class QueenB {
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            pos[i] = j;
            if (i == 7)
                print();
            else
                set(i + 1);
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
