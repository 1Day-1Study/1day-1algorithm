package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2230 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seq);

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int diff = seq[right] - seq[left];

            if (diff >= M) {
                min = Math.min(min, diff);
                left++;
            } else {
                right++;
                if (right == N) {
                    break;
                }
            }
        }

        System.out.println(min);

    }
}
