package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (List<Integer> integers : graph) {
            Collections.sort(integers);
        }

        dfs(V);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(V);

        System.out.println(sb.toString());
    }

    static void dfs(int start) {
        sb.append(start).append(" ");
        visited[start] = true;
        for (Integer node : graph.get(start)) {
            if (!visited[node]) {
                dfs(node);
            }
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer node : graph.get(current)) {
                if (!visited[node]) {
                    visited[node] = true;
                    sb.append(node).append(" ");
                    queue.add(node);
                }
            }
        }
    }
}
