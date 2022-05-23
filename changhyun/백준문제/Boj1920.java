package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] A;
    static int[] seq;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < seq.length; i++) {

            if (isExist(seq[i])) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }

        System.out.println(sb.toString());

    }

    private static boolean isExist(int target) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (A[mid] == target) {
                return true;
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }
}
