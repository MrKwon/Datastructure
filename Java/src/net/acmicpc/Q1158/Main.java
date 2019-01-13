package net.acmicpc.Q1158;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            int input = Integer.parseInt(reader.readLine());
            arr[i] = input;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i % 42);
        }

        System.out.println(set.size());
    }
}
