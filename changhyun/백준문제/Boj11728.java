package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11728 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] seq;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[N + M];
        int idx = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[idx++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            seq[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        for (int i : seq) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());

    }
}
