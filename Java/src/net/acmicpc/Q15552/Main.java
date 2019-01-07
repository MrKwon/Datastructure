package net.acmicpc.Q15552;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(reader.readLine());

        for(int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            writer.write(String.valueOf(Integer.valueOf(s[0]) + Integer.valueOf(s[1])) + "\n");
        }
        writer.flush();
        writer.close();
    }
}
