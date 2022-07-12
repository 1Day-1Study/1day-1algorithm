package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17266 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] lamps;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lamps = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int lamp = Integer.parseInt(st.nextToken());
            lamps[i] = lamp;
        }

        int left = 1;
        int right = N;
        while (left <= right) {

            int height = (left + right) / 2;

            if (isCoveredByLight(height)) {
                right = height - 1;
            } else {
                left = height + 1;
            }

        }

        System.out.println(left);

    }

    static boolean isCoveredByLight(int height) {
        int currentPosition = 0;

        for (int i = 0; i < M; i++) {
            int left = lamps[i] - height;
            int right = lamps[i] + height;

            // 처음 지점을 덮지 못하는 경우
            if (currentPosition < left) {
                return false;
            }

            currentPosition = right;
        }

        if (N - currentPosition > 0) {
            return false;
        }

        return true;
    }
}
