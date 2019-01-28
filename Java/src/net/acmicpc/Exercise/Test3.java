package net.acmicpc.Exercise;

import java.util.Stack;

public class Test3 {
    public class Element {
        int index;
        int prices;

        Element(int index, int prices) {
            this.index = index;
            this.prices = prices;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Element> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            Element element = new Element(i, prices[i]);

            if (stack.isEmpty()) {
                stack.push(element);

            } else if (stack.peek().prices < prices[i]) {
                stack.push(element);

            } else if (stack.peek().prices > prices[i]) {
                while (stack.peek().prices < prices[i] || !stack.isEmpty()) {
                    Element tmp = stack.pop();
                    answer[tmp.index] = i - tmp.index;
                    if (stack.isEmpty() || stack.peek().prices < prices[i]) {
                        stack.push(element);
                        break;
                    }
                }
            } else {
                stack.push(element);
            }
        }

        while (!stack.isEmpty()) {
            Element tmp = stack.pop();
            System.out.printf("%d // %d\n", tmp.index, tmp.prices);
            answer[tmp.index] = (prices.length - 1) - tmp.index;
        }

        return answer;
    }

    public static void main(String[] args) {
        Test3 test = new Test3();

        int[] prices = { 1, 0, 1, 1, 1 };
        int[] result = test.solution(prices);

        for (int i : result)
            System.out.println(i);
    }
}

