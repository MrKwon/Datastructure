package net.acmicpc.COCI0607.Q3054;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split("");

        String result;
        String s1 = ""; // 첫번째 줄과 다섯째 줄
        String s2 = ""; // 두번째 줄과 네번째 줄
        String s3 = ""; // 가운데 줄

        for (int i = 0; i < str.length; i++) {
            if (i % 3 == 2) { // 웬디 프레임
                s1 += "..*..";
                s2 += ".*.*.";
                s3 += "*." + str[i] + ".*";

            } else if (i % 3 != 2 || i == str.length - 1) { // 피터팬 프레임 && 마지막 아닐 때
                if (i % 3 != 0 || i == 0) {
                    s1 += ".";
                    s2 += ".";
                    s3 += "#";
                }

                s1 += ".#.";
                s2 += "#.#";
                s3 += "." + str[i] + ".";

                if (i == str.length - 1) {
                    s1 += ".";
                    s2 += ".";
                    s3 += "#";
                }
            }
        }
        result = s1 + "\n"
                + s2 + "\n"
                + s3 + "\n"
                + s2 + "\n"
                + s1 + "\n";

        writer.write(result);

        writer.flush();
        writer.close();
    }
}
