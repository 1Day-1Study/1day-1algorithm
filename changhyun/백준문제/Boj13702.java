package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13702 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] makgeollies;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        makgeollies = new int[N];

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            makgeollies[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, makgeollies[i]);
        }


        long left = 1;
        long right = maxValue;

        while (left <= right) {

            long mid = (left + right) / 2;

            int cnt = 0;
            for (int makgeoli : makgeollies) {
                cnt += makgeoli / mid;
            }

            if (cnt >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(right);


    }
}
