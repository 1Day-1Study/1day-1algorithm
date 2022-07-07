package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<List<Node>> graph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, dist));
            graph.get(end).add(new Node(start, dist));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] isVisited = new boolean[N + 1];
            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(start, 0));

            while (!queue.isEmpty()) {

                Node currentNode = queue.poll();

                if (currentNode.end == end) {
                    sb.append(currentNode.dist).append("\n");
                    break;
                }

                for (Node node : graph.get(currentNode.end)) {
                    if (!isVisited[node.end]) {
                        isVisited[node.end] = true;
                        queue.add(new Node(node.end, currentNode.dist + node.dist));
                    }
                }
            }
        }

        System.out.println(sb.toString());

    }

    static class Node {
        int end;
        int dist;

        public Node(int node, int dist) {
            this.end = node;
            this.dist = dist;
        }
    }
}
