package michael.dsalgo.Chapter05.Queue;


import michael.dsalgo.Chapter05.Execptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);

        Scanner stdIn = new Scanner(System.in);

        int select = -1;
        while (select != 0) {
            System.out.println("1.size / 2.isEmpty / 3.front / 4.enqueue / 5.dequeue / 6.print");
            select = stdIn.nextInt();

            switch (select) {
                case 1:
                    System.out.printf("size : %d\n", queue.size());
                    break;

                case 2:
                    System.out.println("isEmpty? : " + queue.isEmpty());
                    break;

                case 3:
                    try {
                        System.out.printf("front : %d\n", queue.front());
                    } catch (EmptyQueueExecption e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.print("enque what ? : \n");
                    int input = stdIn.nextInt();
                    try {
                        queue.enqueue(input);
                    } catch (FullQueueExecption e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    try {
                        System.out.printf("dequeue : %d\n", queue.dequeue());
                    } catch (EmptyQueueExecption e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println(queue.toString());
                    break;
            }
        }
    }
}
