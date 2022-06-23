package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int[] parent; // 부모 노드가 담긴(=정답이 담긴) 배열
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N + 1];
        parent = new int[N + 1];


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }

    static void dfs(int start) {
        isVisited[start] = true;

        List<Integer> list = graph.get(start);
        for (Integer integer : list) {
            if (!isVisited[integer]) {
                parent[integer] = start;
                dfs(integer);
            }
        }
    }
}
