package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }

                int sum = seq[left] + seq[right];

                if (sum == seq[i]) {
                    cnt++;
                    break;
                }

                if (sum > seq[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(cnt);
    }
}
