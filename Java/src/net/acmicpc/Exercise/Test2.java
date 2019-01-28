package net.acmicpc.Exercise;

import java.util.LinkedList;

public class Test2 {
    public class Node {
        private int location;
        private int priority;

        public Node(int location, int priority) { this.location = location;  this.priority = priority; }
    }

    public Node getMost(LinkedList<Node> list) {
        Node result = list.get(0);
        for (int i = 1; i < list.size(); i++)
            if (result.priority < list.get(i).priority)
                result = list.get(i);
        return result;
    }

    public int solution(int[] priorities, int location) {

        LinkedList<Node> list = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            Node tmp = new Node(i, priorities[i]);
            list.addLast(tmp);
        }

        int most;
        while (!list.isEmpty()) {
            Node tmp;
            most = getMost(list).priority;
            tmp = list.removeFirst();

            if (tmp.priority < most) {
                list.addLast(tmp);
            } else {
                answer++;
                if (tmp.location == location) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        int[] priorities = { 1, 1, 9, 1, 1, 1 };
        int location = 0;

        System.out.println(t.solution(priorities, location));
    }
}
