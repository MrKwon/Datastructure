package net.acmicpc.ACMICPC.Q2319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = reader.readLine().split(" ");
        String chars = reader.readLine().replace(" ", "");

        HashSet<Character> charset = new HashSet<>();
        for (char s : chars.toCharArray())
            charset.add(s);

        for (char s : charset)
            System.out.println(s);
    }
}
