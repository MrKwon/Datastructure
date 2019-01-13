package michael.dsalgo.Chapter05.LinkedListStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NodeStack<Integer> nodeStack = new NodeStack<>();

        Scanner stdIn = new Scanner(System.in);

        int select = -1;
        while (select != 0) {
            System.out.println("1.size / 2.isEmpty / 3.push / 4.pop / 5.top / 6.print");
            select = stdIn.nextInt();

            switch (select) {
                case 1:
                    System.out.printf("size : %d\n", nodeStack.size());
                    break;

                case 2:
                    System.out.println("isEmpty? : " + nodeStack.isEmpty());
                    break;

                case 3:
                    System.out.print("push what ? : \n");
                    int push = stdIn.nextInt();
                    nodeStack.push(push);
                    break;

                case 4:
                    System.out.printf("pop : %d\n", nodeStack.pop());
                    break;

                case 5:
                    System.out.printf("top : %d\n", nodeStack.top());
                    break;

                case 6:
                    System.out.println(nodeStack.toString());
                    break;
            }
        }
    }
}
