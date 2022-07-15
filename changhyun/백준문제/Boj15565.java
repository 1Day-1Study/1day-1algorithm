package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15565 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static List<Integer> riones = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int doll = Integer.parseInt(st.nextToken());

            // 라이언 인형만 저장
            if (doll == 1) {
                riones.add(i);
            }
        }

        // 라이언 인형의 수가 요구하는 K개 이상이어야 되는데
        // K보다 작다면 적합한 집합이 없으므로 -1 출력
        if(riones.size() < K) {
            System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < riones.size() - K + 1; i++) {
            int left = riones.get(i);
            int right = riones.get(i + K - 1);
            min = Math.min(min, right - left);
        }

        System.out.println(min + 1);

    }
}
