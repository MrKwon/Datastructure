package net.acmicpc.Q10799;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split("");
        Stack<Integer> stack = new Stack<>();

        String in = "hello";

        int result = 0;
        int ppreStkSize;
        int preStkSize = 0; // 이전 size

        for (int i = 0; i < input.length; i++) {
            ppreStkSize = preStkSize;
            if (i != 0) preStkSize = stack.size();

            if (input[i].equals("(")) // 무조건 push 하는 경우
                stack.push(1);

            else { // 무조건 pop 하는 경우
                stack.pop();
                if (ppreStkSize == stack.size() && ppreStkSize < preStkSize) {
                    result += ppreStkSize;
                }
                else if(ppreStkSize > stack.size()) {
                    result += 1;
                }
            }
        }

        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
    }
}
