package michael.dsalgo.Chapter06.ArrayIndexList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayIndexList<String> list = new ArrayIndexList<>();

        Scanner stdIn = new Scanner(System.in);

        while (true) {
            System.out.print("\n\n[[ArrayIndexList Tester]]\n" +
                            "1. size()      2. isEmpty()      3. get(i)     4. set(i, e)\n" +
                            "5. add(i, e)   6. remove(i)                    9. print\n" +
                            "choose menu : ");
            int select = stdIn.nextInt();
            int i;
            String e;
            switch (select) {
                case 1:
                    System.out.println(list.size());
                    break;

                case 2:
                    System.out.println(list.isEmpty());
                    break;

                case 3:
                    System.out.print("get(i), i = ? : ");
                    i = stdIn.nextInt();
                    try {
                        System.out.println(list.get(i));
                    } catch (IndexOutOfBoundsException err) {
                        System.out.printf("%d is not a valid index\n", i);
                    }
                    break;

                case 4:
                    System.out.print("set(i, e), i = ? : ");
                    i = stdIn.nextInt();
                    System.out.print("set(i, e), e = ? : ");
                    e = stdIn.next();
                    try {
                        System.out.println(list.set(i, e));
                    } catch (IndexOutOfBoundsException err) {
                        System.out.printf("%d is not a valid index\n", i);
                    }
                    break;

                case 5:
                    System.out.print("add(i, e), i = ? : ");
                    i = stdIn.nextInt();
                    System.out.print("add(i, e), e = ? : ");
                    e = stdIn.next();
                    try {
                        list.add(i, e);
                        System.out.printf("Add %s at %d, complete\n", e, i);
                    } catch (IndexOutOfBoundsException err) {
                        System.out.printf("%d is not a valid index\n", i);
                    }
                    break;

                case 6:
                    System.out.print("remove(i), i = ? : ");
                    i = stdIn.nextInt();
                    try {
                        System.out.println(list.remove(i));
                    } catch (IndexOutOfBoundsException err) {
                        System.out.printf("%d is not a valid index\n", i);
                    }
                    break;

                case 9:
                    System.out.println(list.toString());
                    break;
            }

            if (select == 0) break;
        }
    }
}
