package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E, K;
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        priorityQueue.add(new Node(K, 0));
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (dist[current.end] < current.weight) {
                continue;
            }

            for (Node next : graph.get(current.end)) {
                if (dist[next.end] > dist[current.end] + next.weight) {
                    dist[next.end] = dist[current.end] + next.weight;
                    priorityQueue.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }


    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
