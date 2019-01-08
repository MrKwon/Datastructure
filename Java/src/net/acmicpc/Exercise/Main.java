package net.acmicpc.Exercise;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(reader.readLine());

        BigDecimal result;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        result = BigDecimal.valueOf(a).pow(b);
        result = result.remainder(BigDecimal.valueOf(c));

        sb.append(result);

        System.out.println(sb);
    }
}
