package net.acmicpc.Exercise;

import java.io.*;

public class Main {
    static private int[] locD = new int[2]; // D 굴 위치 (locD[0], locD[1])
    static private int[] locS = new int[2]; // S 고슴도치 위치 (locS[0], locS[1])

    static private String[][] map; // 지도
    static private int dist = 0; // 이동 거리

    private static String[][] deepCopy(String[][] input) {
        if (input.length == 0) return null;

        String[][] result = new String[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            System.arraycopy(input[i], 0, result[i], 0, input[i].length);
        }

        return result;
    }

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
                    if (map[i - 1][j].equals(".")) tmp[i - 1][j] = "*";
                    if (map[i + 1][j].equals(".")) tmp[i + 1][j] = "*";
                    if (map[i][j - 1].equals(".")) tmp[i][j - 1] = "*";
                    if (map[i][j + 1].equals(".")) tmp[i][j + 1] = "*";
                }
            }
        }

        map = deepCopy(tmp);
    }

    private static int move() {
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

        writer.flush();
        writer.close();
    }
}
