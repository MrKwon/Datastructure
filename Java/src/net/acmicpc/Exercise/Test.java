package net.acmicpc.Exercise;

import java.util.Arrays;

public class Test {
    public int solution(int stock, int[] date, int[] supplie, int k) {
        int answer = 0;

        int curStock = stock;
        int[] dates = new int[date.length + 1];
        int[] supplies = new int[supplie.length + 1];

        System.arraycopy(date, 0, dates, 0, date.length);
        System.arraycopy(supplie, 0, supplies, 0, supplie.length);
        dates[dates.length - 1] = k;

        for (int i = 1; i < dates.length; i++) {
            curStock -= dates[i - 1];
            k -= dates[i - 1];
            if (dates[i] - dates[i - 1] > curStock) {
                System.out.println(dates[i] - dates[i - 1]);
                curStock += supplies[i - 1];
                if (supplies[i] != 0) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test t = new Test();
        int stock = 31; // dates = 0;
        int[] dates = { 4, 10, 15 };
        int[] supplies = { 20, 5, 15 };
        int k = 30;

        System.out.println(t.solution(stock, dates, supplies, k));
    }
}
