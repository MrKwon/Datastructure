package net.acmicpc.Q1788;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static long fib(int n) {
//        ArrayList<Integer> arr = new ArrayList<>();
        long[] arr = new long[1000000 + 1];

//        arr.add(0, 0);
//        arr.add(1, 1);
        arr[0] = 0;
        arr[1] = 1;

        if (n == 0) return 0;
        if (n == 1) return 1;

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
//                arr.add(i, (arr.get(i - 2) + arr.get(i - 1)) % 1000000000);
                arr[i] = (arr[i - 2] + arr[i - 1]) % 1000000000;
            }

        } else { // n <= 1
            n = Math.abs(n);
            for (int i = 2; i <= n; i++) {
//                arr.add(i, (arr.get(i - 2) - arr.get(i - 1)) % 1000000000);
                arr[i] = ((arr[i - 2] - arr[i - 1]) % 1000000000);
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = stdIn.nextInt();

        long result = fib(n);

        if (result < 0) {
            sb.append(-1);
        } else if (result == 0) {
            sb.append(0);
        } else {
            sb.append(1);
        }
        sb.append(System.getProperty("line.separator"));

        sb.append(Math.abs(result));
        sb.append(System.getProperty("line.separator"));

        System.out.println(sb);
    }
}
