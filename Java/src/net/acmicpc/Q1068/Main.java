package net.acmicpc.Q1068;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static class Node {
        int parent;
        int childNum;

        public Node(int parent, int childNum) {
            this.parent = parent;
            this.childNum = childNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] inputs = reader.readLine().split(" "); // 노드 배열
        int remove = Integer.parseInt(reader.readLine()); // 지우려는 노드 인덱스

        Node[] tree = new Node[n];

        for (int i = 0; i < tree.length ; i++) {
            // parent는 inputs 에 주어짐
            // child num은 일단 모르니까 0
            Node tmp = new Node(Integer.valueOf(inputs[i]), 0);
            tree[i] = tmp;
        }


        // 그럼 이제 자식 노드의 수를 구해야 함
        for (int i = 0; i < inputs.length; i++)
            for (int j = 0; j < inputs.length; j++)
                if(i == Integer.parseInt(inputs[j])) // index가 parent에 저장된 원소 수만큼 ++
                    tree[i].childNum++;

        LinkedList<Integer> list = new LinkedList<>();
        // 현재 index의 자식 노드들을 likedlist에 저장하고
        // 큐에서 하나씩 removeFirst 하면서 그에 해당되는 parent를 가진 것을 중복없이
        list.addLast(remove);

        while(!list.isEmpty()) {
            if (tree[remove].childNum == 0 && tree[remove].parent != -1) {
                tree[remove].childNum--;
                tree[tree[remove].parent].childNum--;
            } else {
                int toRemove = list.removeFirst();
                System.out.println("toRemove : " + toRemove);
                for (int i = 0; i < tree.length; i++) { //  지우는 노드의 자식 노드를 set에 저장
                    if (tree[i].parent == toRemove && !list.contains(tree[i].parent)) {
                        list.addLast(i);
                        tree[i].childNum--;
//                        System.out.println("전 : " + tree[tree[i].parent].childNum);
                        tree[tree[i].parent].childNum--;
//                        System.out.println("후 : " + tree[tree[i].parent].childNum);
                    }
                }
            }
//
//            for (int i : list) {
//                System.out.println("List : " + i);
//            }
        }
//
//        for (Node e : tree) {
//            System.out.println(e.parent + " | " + e.childNum);
//        }

        int result = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i].childNum == 0 && tree[i].parent != -1)
                result++;
        }

        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
    }
}

