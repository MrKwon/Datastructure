package net.acmicpc.Q1002;

import java.io.*;


/**
 * 아오 수박.........
 * 런타임에러는 뭔데 시밤
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());

        while(n-- > 0) {
            String[] s = reader.readLine().split(" ");
            int[] in = new int[s.length];

            for (int i = 0; i < s.length; i++) {
                in[i] = Integer.parseInt(s[i]);
            }

            int dist = (in[3] - in[0]) * (in[3] - in[0]) + (in[4] - in[1]) * (in[4] - in[1]);
            int r1r2 = (in[2] + in[5]) * (in[2] + in[5]);

            if (in[0] == in[3] && in[1] == in[4] && in[2] == in[5]) {
                sb.append(-1);
                sb.append(System.getProperty("line.separator"));
            } else if (r1r2 == dist || (Math.sqrt(dist) + in[2] == in[5] || Math.sqrt(dist) + in[5] == in[2])) {
                sb.append(1);
                sb.append(System.getProperty("line.separator"));
            } else if (r1r2 < dist || (Math.sqrt(dist) + in[2] < in[5] || Math.sqrt(dist) + in[5] < in[2])) {
                sb.append(0);
                sb.append(System.getProperty("line.separator"));
            } else {
                sb.append(2);
                sb.append(System.getProperty("line.separator"));
            }
        }

        System.out.println(sb);
    }
}
