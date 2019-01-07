package net.acmicpc.Q1002;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    private static int[] strToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++)
            result[i] = Integer.parseInt(s[i]);
        return result;
    }

    private static BigDecimal getDist(int[] arr) {
        return BigDecimal.valueOf(Math.sqrt(Math.pow(arr[3] - arr[0], 2) + Math.pow(arr[4] - arr[1], 2)));
    }

    private static BigDecimal toBig(int a) {
        return BigDecimal.valueOf(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int[] info = strToIntArr(reader.readLine().split(" "));

            if (info[0] == info[3] && info[1] == info[4]) {
                if (info[2] == info[5]) {
                    sb.append("-1");
                    sb.append(System.getProperty("line.separator"));
                } else {
                    sb.append("0");
                    sb.append(System.getProperty("line.separator"));
                }
            } else {
                if (getDist(info).compareTo(toBig(info[2] + info[5])) == -1 || getDist(info).compareTo(toBig(info[2] - info[5])) == -1 ) {
                    sb.append("2");
                    sb.append(System.getProperty("line.separator"));
                } else if (getDist(info).compareTo((toBig(info[2] + info[5]))) == 0 || getDist(info).compareTo((toBig(info[2] - info[5]))) == 0 ) {
                    sb.append("1");
                    sb.append(System.getProperty("line.separator"));
                } else {
                    sb.append("0");
                    sb.append(System.getProperty("line.separator"));
                }
            }
        }

        System.out.println(sb);
    }
}
