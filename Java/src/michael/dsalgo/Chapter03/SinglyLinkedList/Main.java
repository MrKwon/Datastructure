package michael.dsalgo.Chapter03.SinglyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int select;
        do {
            System.out.printf("수행할 기능을 선택하시오.\n" +
                    "1. addFirst    2. addLast\n" +
                    "3. removeFirst 4. removeLast\n" +
                    "5. print\n" +
                    ": ");
            select = stdIn.nextInt();
            int num;
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
                    System.out.println("[list 원소 출력]");
                    System.out.println(list.toString());
            }

        } while (select != 0);

    }
}
