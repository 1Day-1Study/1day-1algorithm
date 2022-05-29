package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] liquid;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        liquid = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int A = 0;
        int B = N - 1;

        int resultA = 0;
        int resultB = 0;
        int min = Integer.MAX_VALUE;
        while (A < B) {
            int sum = liquid[A] + liquid[B];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                resultA = liquid[A];
                resultB = liquid[B];
            }

            if (sum > 0) {
                B--;
            } else if (sum < 0) {
                A++;
            }else{
                System.out.println(resultA + " " + resultB);
                return;
            }

        }

        System.out.println(resultA + " " + resultB);
    }
}
