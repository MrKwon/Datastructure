package net.acmicpc.Exercise;

import java.io.*;
import java.util.ArrayList;

public class Test4 {
    public static class Node {
        int parent;
        int childNum;

        public Node(int parent, int childNum) {
            this.parent = parent;
            this.childNum = childNum;
        }
    }

    public static int parent(ArrayList<Node> list, int index) {
        return list.get(index).parent;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        String[] inputs = reader.readLine().split(" ");
        int remove = Integer.parseInt(reader.readLine());

        ArrayList<Node> tree = new ArrayList<>();

        for(String s : inputs)
            tree.add(new Node(Integer.parseInt(s), 0));

        for (int i = 0; i < tree.size(); i++)
            for (int j = 0; j < tree.size(); j++) {
                if (tree.get(j).parent == i)
                    tree.get(i).childNum++;
            }

        int index = tree.size();
        int leaf = 0;
        for (Node node : tree)
            if (node.childNum == 0)
                leaf++;

        while (--index >= 0) {
            int parent = tree.get(index).parent;
            while (true) {
                if (parent == -1) break;
                else if (parent == remove && tree.get(index).childNum == 0) {
                    leaf--;
                    tree.get(parent).childNum = 0;
                    break;
                }
                parent = parent(tree, parent);
            }
        }

        if (tree.get(remove).parent == 0 || remove == 0) leaf--;

        writer.write(String.valueOf(leaf));
        writer.flush();
        writer.close();
    }
}
