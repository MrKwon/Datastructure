package net.acmicpc.Q3986;

import java.io.*;
import java.util.Stack;

/**
 * print 할게 마지막에 딱하나라면
 * System println 을 쓰는게 더 빠름. 메모리도 덜 잡아먹고
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputs = Integer.parseInt(reader.readLine());

        int results = 0;

        while (inputs-- > 0) {
            Stack<Character> stack = new Stack<>();

            char[] s = reader.readLine().toCharArray();

            for (char e : s)
                if (stack.isEmpty() || !stack.peek().equals(e)) stack.push(e);
                else stack.pop();

            if (stack.isEmpty()) results += 1;
        }

        System.out.println(results);
    }
}
