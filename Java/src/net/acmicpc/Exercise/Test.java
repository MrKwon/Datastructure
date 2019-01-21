package net.acmicpc.Exercise;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> nums = new ArrayList<>();

        Comparator<String> comp
                = (o1, o2) -> o1.length() < o2.length() ? // o1 길이가 o2 보다 짧으면
                Integer.compare(o1.indexOf(0), o2.indexOf(0)) :
                (o1.length() > o2.length() ?
                Integer.compare(o1.indexOf(0), o2.indexOf(0)) * -1 :
                Integer.compare(Integer.valueOf(o1), Integer.valueOf(o2)));

        for(int i = 0; i < numbers.length; i++) {
            System.out.println(i);
            nums.add(i, String.valueOf(numbers[i]));
        }

        nums.sort(comp);

        for(int i = nums.size() - 1; i >= 0; i--) {
            answer += nums.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] array = { 3, 30, 34, 5, 9 };
        System.out.println(test.solution(array));
    }
}
