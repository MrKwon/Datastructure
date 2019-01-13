package net.acmicpc.COCI0607.Q3053;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        writer.write(String.format("%.6f", Math.pow(input, 2) * Math.PI) + "\n");
        writer.write(String.format("%.6f", Math.pow(Math.sqrt(2) * input, 2)) +"\n");

        writer.flush();
        writer.close();
    }
}
