package net.acmicpc.Exercise;

public class Main {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        int[] tmp = priorities;
        int first = 0;
        int last = tmp.length - 1;

        while (true) {

            int big = tmp[first % tmp.length];

            System.out.printf("first = %d %d, last = %d %d, location = %d\n", first, tmp[first % tmp.length], last, tmp[last % tmp.length], location);

            for (int i = first % tmp.length; i <= last % tmp.length; i++) {
                System.out.printf("%d ", tmp[i]);
            }
            System.out.println();

            for (int i = first + 1; i <= last; i++) { // 첫번째 원소 이외에 가장 큰 원소
                if (tmp[i % tmp.length] > big)
                    big = tmp[i % tmp.length];
            }

            System.out.printf("big = %d\n", big);

            answer++;
            if (tmp[first % tmp.length] < big) {
                first++;
                last++;
                if (first % tmp.length == location % tmp.length)
                    location = last;

            } else {
                if (first % tmp.length == location % tmp.length)
                    return answer;

                else {
                    first++;
                    int[] tmptmp = new int[tmp.length - 1];
                    for (int j = 0; j < tmptmp.length; j++) {
                        tmptmp[j] = tmp[(first + 1 + j) % tmp.length];
                    }
                    tmp = tmptmp;
                    first = 0;
                    last = tmp.length;
                }
            }

            if (first == last) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] pri = {1, 1, 9, 1, 1, 1};
        int loc = 0;

        System.out.println(solution(pri, loc));
    }
}
