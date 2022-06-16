package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2343 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] lesson;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lesson = new int[N];

        long sum = 0;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lesson[i]);
            sum += lesson[i];
        }

        long left = max;
        long right = sum;

        while (left <= right) {

            long mid = (left + right) / 2;

            int cnt = countBlueray(mid);

            if (cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    static int countBlueray(long mid) {
        int cnt = 1;
        long currentSize = mid;
        for (int i = 0; i < N; i++) {
            if (currentSize < lesson[i]) {
                currentSize = mid - lesson[i];
                cnt++;
            } else {
                currentSize -= lesson[i];
            }
        }

        return cnt;
    }
}
