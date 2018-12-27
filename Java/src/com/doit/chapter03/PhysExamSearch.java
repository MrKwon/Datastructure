package com.doit.chapter03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

    static class PhysData {
        private String name;
        private int height;
        private double vision;

        public PhysData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhysData> HEIGHT_ORDER
                = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysData> {
            @Override
            public int compare(PhysData o1, PhysData o2) {
                return (o1.height > o2.height) ? 1 :
                        (o1.height < o2. height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhysData[] x = {
                new PhysData("이나령", 162, 0.3),
                new PhysData("유지훈", 168, 0.4),
                new PhysData("김한결", 169, 0.8),
                new PhysData("홍준기", 171, 1.5),
                new PhysData("진서현", 173, 0.7),
                new PhysData("이호연", 174, 1.2),
                new PhysData("이수민", 175, 2.0),
        };

        System.out.print("몇 cm인 사람을 찾고 있나요 ? : ");
        int height = stdIn.nextInt();
        int index = Arrays.binarySearch(
                x,
                new PhysData("", height, 0.0),
                PhysData.HEIGHT_ORDER
        );

        if (index < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + index + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[index]);
        }
    }
}
