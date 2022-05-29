package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K, N;
    static int[] wires;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wires = new int[K];

        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, wires[i]);
        }

        long left = 1;
        long right = maxLength;

        while (left <= right) {
            long mid = (left + right) / 2;

            int cnt = 0;
            for (int wire : wires) {
                cnt += wire / mid;
            }

            if (cnt < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);

    }
}
