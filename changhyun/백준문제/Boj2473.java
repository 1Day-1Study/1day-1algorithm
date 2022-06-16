package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2473 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long[] liquid;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        liquid = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        for (int i = 0; i < N - 2; i++) {

            int A = i;
            int B = i + 1;
            int C = N - 1;

            while (B < C) {
                long sum = liquid[A] + liquid[B] + liquid[C];
                long absSum = Math.abs(sum);

                if (min > absSum) {
                    min = absSum;
                    answer[0] = liquid[A];
                    answer[1] = liquid[B];
                    answer[2] = liquid[C];
                }

                if (sum > 0) {
                    C--;
                } else if (sum < 0) {
                    B++;
                } else {
                    print(answer);
                    return;
                }

            }
        }

        print(answer);
    }

    static void print(long[] answer) {
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
