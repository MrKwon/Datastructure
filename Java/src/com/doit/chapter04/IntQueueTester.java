package com.doit.chapter04;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue q = new IntQueue(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + q.size() + " / " + q.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (5)찾기 (0)종료 : ");

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
                    try {
                        x = q.peek();
                        System.out.println("peek data is " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 4:
                    q.dump();
                    break;

                case 5:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    int position = q.search(x);
                    if (x == 0)
                        System.out.println("찾는 " + x + " 가 존재하지 않습니다.");
                    else
                        System.out.println( x + " 는 " + position + " 에 위치합니다.");

                    break;
            }
        }
    }
}
