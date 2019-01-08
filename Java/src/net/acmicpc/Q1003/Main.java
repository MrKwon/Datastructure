package net.acmicpc.Q1003;

import java.io.*;

/**
 * 뭐냐이건또 시밤
 * 지금 코드는 실행하면 답 안나옴,
 * 재귀로 풀면 시간초과 나오는데 배열로 고쳐서 풀어야 하는 것 같은데 배열로 고치면 카운팅이 안되네
 */
public class Main {
    private static int ZERO = 0;
    private static int ONE = 0;

    private static void fib(int n) {
        int[] arr = new int[n];

        if (n == 0) {
            ZERO++;
        } else if (n == 1) {
            ONE++;
        } else {
            arr[0] = 0;
            arr[1] = 1;

            for(int i = 2; i < n; i++) {
                if (i - 2 == 0) ZERO++;
                else if (i - 2 == 1) ONE++;
                else {
                    ONE++;
                    ZERO++;
                }

                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputs = Integer.parseInt(reader.readLine());

        while (inputs-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            fib(n);
            System.out.printf("%d %d\n", ZERO, ONE);
            ZERO = ONE = 0;
        }
    }
}
