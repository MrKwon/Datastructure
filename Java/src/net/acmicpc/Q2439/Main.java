package net.acmicpc.Q2439;

import java.util.Scanner;

public class Main {
    public static void multPrint(int n, String s) {
        for (int i = 0; i < n; i++)
            System.out.print(s);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        for(int i = 1; i <= n; i++) {
            multPrint(n - i, " ");
            multPrint(i, "*");
            System.out.println();
        }
    }
}
