package net.acmicpc.Q10828;

import java.util.Scanner;

public class Main {
    static class Stack {
        private int capacity;
        private int num;
        private int[] stk;

        public Stack() {
            this.num = 0;
            this.capacity = 4;
            this.stk = new int[this.capacity];
        }

        private void stackSizeUp() {
            int tmpCap = this.capacity;
            int[] tmpStk = this.stk;

            this.capacity = 2 * tmpCap - 1;
            stk = new int[this.capacity];

            for (int i = 0; i < tmpStk.length; i++)
                stk[i] = tmpStk[i];
        }

        public void push(int x) {
            if (this.capacity == this.num)
                stackSizeUp();

            this.stk[this.num++] = x;
        }

        public int pop() {
            if (this.num <= 0)
                return -1;

            return this.stk[--this.num];
        }

        public int size() {
            return this.num;
        }

        public int empty() {
            if (this.size() <= 0)
                return 1;
            return 0;
        }

        public int top() {
            if (this.num <= 0)
                return -1;

            return this.stk[this.num - 1];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Stack stack = new Stack();

        int inputs = stdIn.nextInt();

        for(int i = 0; i < inputs; i++) {
            String command = stdIn.next();

            switch(command) {
                case "push":
                    int x = stdIn.nextInt();
                    stack.push(x);
                    break;

                case "pop":
                    System.out.println(stack.pop());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.empty());
                    break;

                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }
    }
}
