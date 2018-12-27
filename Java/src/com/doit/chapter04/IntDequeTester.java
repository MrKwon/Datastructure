package com.doit.chapter04;

import java.util.Scanner;

public class IntDequeTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDeque q = new IntDeque(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + q.size() + " / " + q.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)리버스인큐 (4)리버스디큐 (5)덤프 (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        q.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        q.deque();
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 3:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        q.reverseEnque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 4:
                    try {
                        q.reverseDeque();
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 5:
                    q.dump();
                    break;
            }
        }
    }
}
