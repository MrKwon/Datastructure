package net.acmicpc.Q10828;

import java.io.*;
import java.util.Stack;

/**
 * java에 정의된 Stack 클래스를 이용한 문제풀이
 * 404ms 인데 input 처리 때문에 404ms 가 걸리는 것 같네
 *
 * input을 BufferedReader로 처리하면 268ms로 줄어듦 (Scanner 사용 자제)
 *
 * output을 BufferedWriter로 처리하면 164ms로 줄어듦 (한번에 몰아 출력할때는 System.out.println 자제)
 */
public class Object {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int inputs = Integer.parseInt(reader.readLine());

        for(int i = 0; i < inputs; i++) {
            String s[] = reader.readLine().split(" ");

            switch(s[0]) {
                case "push":
                    stack.push(Integer.parseInt(s[1]));
                    break;

                case "pop":
                    if (stack.size() == 0)
                        writer.write("-1\n");
                    else
                        writer.write(stack.pop() + "\n");
                    break;

                case "size":
                    writer.write(stack.size() + "\n");
                    break;

                case "empty":
                    writer.write((stack.empty() ? 1 : 0 )+ "\n");
                    break;

                case "top":
                    if (stack.size() == 0)
                        writer.write("-1\n");
                    else
                        writer.write(stack.peek() + "\n");
                    break;
            }
        }
        writer.flush();
        writer.close();
    }
}
