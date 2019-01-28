package net.acmicpc.Recursion.Q4463;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Integer> fib(long max) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(0, 0);
        arr.add(1, 1);

        int i = 2;
        while (arr.get(i - 1) < max) {
            arr.add(i, arr.get(i - 2) + arr.get(i - 1));
            System.out.println(arr.get(i));
            i++;
        }

        return arr;
    }

    private static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                result.add(i);
                if (n == 0) break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while ((input = reader.readLine()) != null) { // eof 중지하게 만들기
            StringTokenizer st = new StringTokenizer(input, " ");

            if (!st.hasMoreTokens()) break;

            String strLo = st.nextToken().replace("0x", "");
            String strHi = st.nextToken().replace("0x", "");

            long lo = Long.valueOf(strLo, 16);
            long hi = Long.valueOf(strHi, 16);

            if (lo >= hi) break;

            ArrayList<Integer> fib = fib(hi);

            boolean isFirst = false; // flag
            int i = 0;
            writer.write("Range " + lo + " to " + hi + ":\n");
            for (int ele : fib) {
                if (lo <= ele && ele <= hi) {
                    // fib와 log 구하기
                    writer.write("Fib(" + i + ") = " + ele + ", ");
                    isFirst = true;
                    if (ele == 0)
                        writer.write("lg does not exist\n");
                    else {
                        String eleStr = String.format("%.6f", Math.log(ele) / Math.log(2));
                        writer.write("lg is " + eleStr + "\n");
                    }

                    //prime 구하기
                    ArrayList<Integer> prime = getPrimes(ele);

                    if (prime.isEmpty()) {
                        writer.write("No prime factors\n");
                    } else {
                        writer.write("Prime factors: " +
                                prime.toString()
                                        .replace(", ", " ")
                                        .replace("[", "")
                                        .replace("]", "") + "\n");
                    }

                } else if (ele > hi && !isFirst) {
                    writer.write("No Fibonacci numbers in the range\n");
                }
                // else 인 경우 skip
                i++;
            }
            writer.write("\n");
        }

        writer.flush();
        writer.close();
    }
}
