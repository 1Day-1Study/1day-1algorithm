package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2623 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] inDegree;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) {
                continue;
            }
            int frontSinger = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int secondSinger = Integer.parseInt(st.nextToken());
                graph.get(frontSinger).add(secondSinger);
                inDegree[secondSinger]++;
                frontSinger = secondSinger;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            sb.append(current).append("\n");
            for (Integer next : graph.get(current)) {
                if (--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() != N * 2) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }

    }
}
