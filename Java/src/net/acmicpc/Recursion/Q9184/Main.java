package net.acmicpc.Recursion.Q9184;

import java.io.*;

public class Main {
    public static int[][][] wArr = new int[21][21][21];

    public static int w(int a, int b, int c) {
        if (wArr[a][b][c] != 0) return wArr[a][b][c];
        else if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        else if (a > 20 || b > 20 || c > 20) {
            wArr[a][b][c] = w(a, b, c);
        }
        else if (a < b && b < c) {
            wArr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        else {
            wArr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return wArr[a][b][c];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s;

        while(true) {
            s = reader.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            if (a == -1 && b == -1 && c == -1) break;

            if (a <= 0 || b <= 0 || c <= 0)
                writer.write("w(" + a + ", " + b + ", " + c + ") = " + w(0, 0, 0) + "\n");
            else if ( a > 20 || b > 20 || c > 20)
                writer.write("w(" + a + ", " + b + ", " + c + ") = " + w(20, 20, 20) + "\n");
            else {
                writer.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
            }
        }

        writer.flush();
        writer.close();
    }
}
