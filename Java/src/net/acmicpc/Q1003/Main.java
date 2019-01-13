package net.acmicpc.Q1003;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputs = Integer.parseInt(reader.readLine());

        int[][] zerone = new int[41][2];
        zerone[0][0] = 1; zerone[0][1] = 0;
        zerone[1][0] = 0; zerone[1][1] = 1;

        while(inputs-- > 0) {
            int n = Integer.parseInt(reader.readLine());

            if (n < 2) {
                writer.write(zerone[n][0] + " " + zerone[n][1] + "\n");
            } else {
                int i = 2;
                while (i <= n) {
                    zerone[i][0] = zerone[i - 1][0] + zerone[i - 2][0];
                    zerone[i][1] = zerone[i - 1][1] + zerone[i - 2][1];
                    i++;
                }
                writer.write(zerone[n][0] + " " + zerone[n][1] + "\n");
            }
        }

        writer.flush();
        writer.close();
    }
}
