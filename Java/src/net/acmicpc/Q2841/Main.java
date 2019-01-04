package net.acmicpc.Q2841;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

/**
 * 런타임 에러가 난다 아무래도 hashmap의 value 에 stack 을 할당해서 그런 것 같음
 */
public class Main {
    public static int toInt(String s) {
        int result;
        result = Integer.valueOf(s);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");

        int result = 0;
        HashMap<Integer, Stack<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < Integer.parseInt(inputs[0]); i++) {
            String[] s = reader.readLine().split(" ");
            Stack<Integer> tmp = new Stack<>();

            if (hashMap.containsKey(toInt(s[0]))) { // s[0]을 포함하고 있으면
                if (hashMap.get(toInt(s[0])).isEmpty() || hashMap.get(toInt(s[0])).peek() < toInt(s[1]) ) {
                    hashMap.get(toInt(s[0])).push(toInt(s[1]));
                    result++;
                } else if (hashMap.get(toInt(s[0])).peek() > toInt(s[1])) {
                    while (hashMap.get(toInt(s[0])).peek() > toInt(s[1])) {
                        hashMap.get(toInt(s[0])).pop();
                        result++;
                        if (hashMap.get(toInt(s[0])).isEmpty()) break;
                    }

                    if (hashMap.get(toInt(s[0])).peek() != toInt(s[1])) {
                        hashMap.get(toInt(s[0])).push(toInt(s[1]));
                        result++;
                    }
                }

            } else {
                hashMap.put(toInt(s[0]), tmp);
                hashMap.get(toInt(s[0])).push(toInt(s[1]));
                result++;
            }
        }
        System.out.println(result);
    }
}
