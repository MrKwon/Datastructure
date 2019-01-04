package net.acmicpc.Q9012;

import java.io.*;
import java.util.Stack;


/**
 * 실행시간 102ms - 생각보다 짧게 걸림 근데 코드가 안이쁘다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputs = Integer.parseInt(reader.readLine());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < inputs; i++) {
            String s[] = reader.readLine().split("");

            for (int j = 0; j < s.length; j++){
                if (stack.size() == 0 && s[j].equals("(")) {
                    stack.push(s[j]);
                } else if (stack.size() == 0 && !s[j].equals("(")) {
                    writer.write("NO\n");
                    break;
                } else if (stack.peek().equals(s[j])) {
                    stack.push(s[j]);
                } else if (stack.peek().equals("(") && !s[j].equals("(")) {
                    stack.pop();
                }

                if (j == s.length - 1) {
                    if (stack.isEmpty())
                        writer.write("YES\n");
                    else
                        writer.write("NO\n");
                }
            }
            stack.clear();
        }

        writer.flush();
        writer.close();
    }
}
