package net.acmicpc.Q11653;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> getPrimes(int n) {
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

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = stdIn.nextInt();

        ArrayList<Integer> arr = getPrimes(n);

        for (int i : arr) {
            sb.append(i);
            sb.append(System.getProperty("line.separator"));
        }

        System.out.println(sb);
    }
}
