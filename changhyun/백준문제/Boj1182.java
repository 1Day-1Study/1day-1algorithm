package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182 {

    static int[] seq;
    static boolean[] isVisited;
    static int cnt = 0;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        seq = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        // S가 0일 때, 아무 원소도 부분 수열에 들어가있지 않은 상태를 --
        if (S == 0) {
            cnt--;
        }

        System.out.println(cnt);

    }

    static void dfs(int sum, int length) {
        if (length == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        dfs(sum, length + 1); //현재 원소를 부분수열에 합치지 않고 진행
        dfs(sum + seq[length], length + 1); // 현재 원소를 부분수열에 합치고 진행

    }
}
