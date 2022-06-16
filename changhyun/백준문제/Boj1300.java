package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K, N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = K;

        while (left <= right) {

            int mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
