package michael.dsalgo.Chapter03.DoublyLinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        int select;
        do {
            System.out.printf("[[Doubly Linked List Tester]]\n" +
                    "1. addFirst    2. addLast\n" +
                    "3. removeFirst 4. removeLast\n" +
                    "5. addAfter    6. removeAfter\n" +
                    "7. print\n" +
                    ": ");
            select = stdIn.nextInt();
            int num;
            int point;
            switch (select) {
                case 1:
                    System.out.println("리스트 머리에 추가할 원소 : ");
                    num = stdIn.nextInt();
                    list.addFirst(num);
                    break;
                case 2:
                    System.out.println("리스트 꼬리에 추가할 원소 : ");
                    num = stdIn.nextInt();
                    list.addLast(num);
                    break;
                case 3:
                    System.out.println("머리 원소 삭제");
                    list.removeFirst();
                    break;
                case 4:
                    System.out.println("꼬리 원소 삭제");
                    list.removeLast();
                    break;
                case 5:
                    System.out.println("point 뒤에 추가할 원소 num");
                    System.out.print("point : ");
                    point = stdIn.nextInt();
                    System.out.print("num : ");
                    num = stdIn.nextInt();
                    list.addAfter(point, num);
                    break;
                case 6:
                    System.out.println("point 뒤에 있는 원소 삭제");
                    System.out.println("point : ");
                    point = stdIn.nextInt();
                    list.removeAfter(point);
                    break;
                case 7:
                    System.out.println("[list 원소 출력]");
                    System.out.println(list.toString());
                    break;
            }

        } while (select != 0);
    }
}
