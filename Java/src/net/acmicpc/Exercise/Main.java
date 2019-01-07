package net.acmicpc.Exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        int kg = stdIn.nextInt();
        int result = 0;

        while (true) {
            if (kg == 0) {
                break;

            } else if (kg % 5 == 0 && kg % 3 == 0) {
                result += kg / 5;
                kg -= 5 * (kg / 5);

            } else if (kg >= 5 && kg % 3 != 0) {
                result += 1;
                kg -= 5;

            } else if (kg >= 3 && kg % 5 != 0) {
                result += 1;
                kg -= 3;

            } else {
                result = -1;
                break;
            }
        }

        System.out.println(result);
    }
}
