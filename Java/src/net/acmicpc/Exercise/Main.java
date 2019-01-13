package net.acmicpc.Exercise;

import java.util.Scanner;

public class Main {
    private static int fib(int n) {
        int[] arr = new int[45 + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++)
            arr[i] = arr[i - 2] + arr[i - 1];

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        System.out.println(fib(n));
    }
}
