package net.acmicpc.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public class Node {
        String s;
        int i;

        public Node(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNums = reader.readLine().split(" ");
        String[] inputStrings = reader.readLine().split("");

        ArrayList<Node> arr = new ArrayList<>();
//
//        for (int i = 0; i < inputNums.length; i++) {
//            Node tmp = new Node(inputNums)
//        }

    }
}
