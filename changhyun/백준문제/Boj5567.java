package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj5567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> friendTree = new ArrayList<>();
    static boolean[] isVisited;
    static int N, M;
    static boolean[] isFriendToInvite;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isVisited = new boolean[N + 1];
        isFriendToInvite = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            friendTree.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            friendTree.get(A).add(B);
            friendTree.get(B).add(A);
        }

        isVisited[1] = true;
        dfs(1, 0);

        int cnt = 0;
        for (boolean b : isFriendToInvite) {
            if (b) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static void dfs(int start, int length) {

        if (length == 2) {
            return;
        }

        for (Integer friend : friendTree.get(start)) {
            if (!isVisited[friend]) {
                isVisited[friend] = true;
                isFriendToInvite[friend] = true;
                dfs(friend, length + 1);
                isVisited[friend] = false;
            }
        }

    }
}
