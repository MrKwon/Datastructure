package net.acmicpc.Q1836;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        if (n == Math.pow(2, k + 1) - 1) {
            writer.write(String.valueOf(1));
        } else {
            double comp = n - (Math.pow(2, k) - 1);
        }

        writer.flush();
        writer.close();
    }
}
