package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1637 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] A, B, C;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());

            min = Math.min(min, A[i]);
            max = Math.max(max, C[i]);
        }

        long left = min;
        long right = max;
        long result = 0;
        while (left <= right) {

            long mid = (left + right) / 2;

            long numberCount = getNumberCount(mid);

            if (numberCount % 2 == 0) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        if (result == 0) {
            System.out.println("NOTHING");
        } else {
            long cnt = getNumberCount(left) - getNumberCount(left - 1);
            System.out.println(left + " " + cnt);
        }

    }

    static long getNumberCount(long mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (mid >= A[i]) {
                cnt += (Math.min(mid, C[i]) - A[i]) / B[i] + 1;
            }
        }
        return cnt;
    }
}
