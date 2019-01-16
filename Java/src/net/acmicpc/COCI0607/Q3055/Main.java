package net.acmicpc.COCI0607.Q3055;

import java.io.*;

public class Main {
    static private int[] locD = new int[2]; // D 굴 위치 (locD[0], locD[1])
    static private int[] locS = new int[2]; // S 고슴도치 위치 (locS[0], locS[1])

    static private String[][] map; // 지도
    static private int dist = 0; // 이동 거리

    private static void printMap(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    private static String[][] deepCopy(String[][] input) {
        if (input.length == 0) return null;

        String[][] result = new String[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            System.arraycopy(input[i], 0, result[i], 0, input[i].length);
        }

        return result;
    }

    /**
     * 현위치 기준 상하 좌우 이동 가능한지?
     * @param x 현재 위치의 x 좌표
     * @param y 현재 위치의 y 좌표
     * @return 상하좌우 이동이 가능하면 true 불가능하면 false
     */
    private static boolean canMove(int x, int y) {
        return (map[x - 1][y].equals(".") || map[x - 1][y].equals("D") ||
                map[x + 1][y].equals(".") || map[x + 1][y].equals("D") ||
                map[x][y - 1].equals(".") || map[x][y - 1].equals("D") ||
                map[x][y + 1].equals(".") || map[x][y + 1].equals("D"));
    }

    private static void waterFlow() {
        String[][] tmp = deepCopy(map);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("*")) {
                    // map 의 원소 중에 *이 있는 위치에 대하여 map 은 기준으로 두기 때문에 바꾸지 않는다
                    if (map[i - 1][j].equals(".")) tmp[i - 1][j] = "*";
                    if (map[i + 1][j].equals(".")) tmp[i + 1][j] = "*";
                    if (map[i][j - 1].equals(".")) tmp[i][j - 1] = "*";
                    if (map[i][j + 1].equals(".")) tmp[i][j + 1] = "*";
                }
            }
        }

        map = deepCopy(tmp);
    }

    private static int move() { // 이동 방법이 틀렸음, 돌아가는 경우를 생각하지 않음
        if (locS[0] == locD[0] && locS[1] == locD[1]) return dist;
        if (!canMove(locS[0], locS[1])) return -1;

        waterFlow();

        if (locS[1] > locD[1] && !map[locS[0]][locS[1]-1].equals("*")) {
            locS[1]--;
        } else if (locS[1] < locD[1] && !map[locS[0]][locS[1]+1].equals("*")) {
            locS[1]++;
        } else if (locS[0] > locD[0] && !map[locS[0]-1][locS[1]].equals("*")) {
            locS[0]--;
        } else if (locS[0] < locD[0] && !map[locS[0]+1][locS[1]].equals("*")) {
            locS[0]++;
        }
        dist++;

        return move();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = reader.readLine().split(" ");

        int R = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);

        map = new String[R + 2][C + 2];

        for (int i = 0; i < R + 2; i++)
            for (int j = 0; j < C + 2; j++) {
                if (i == 0 || j == 0 || i == R + 1 || j == C + 1)
                    map[i][j] = "0";
            }

        for (int i = 1; i < R + 1; i++) {
            String[] mapInfo = reader.readLine().split("");

            int j = 1;
            for (String s : mapInfo) {
                map[i][j] = s;
                if (s.equals("D")) { locD[0] = i; locD[1] = j; }
                if (s.equals("S")) { locS[0] = i; locS[1] = j; map[i][j] = "."; }
                j++;
            }
        }

        int result = move();
        if (result == -1)
            writer.write("KAKTUS");
        else
            writer.write(String.valueOf(result));
//        writer.write("이동 거리 : " + result + "\n");

//        //지도 확인용
//        for (int i = 0; i < R + 2; i++) {
//            for (int j = 0; j < C + 2; j++)
//                writer.write(map[i][j]);
//            writer.write("\n");
//        }
//
//        writer.write("where is D (" + locD[0] + ", " + locD[1] + ")\n");
//        writer.write("where is S (" + locS[0] + ", " + locS[1] + ")\n");

        writer.flush();
        writer.close();
    }
}
