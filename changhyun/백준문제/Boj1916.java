package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int START, END;
    static int[] dist;
    static List<List<Bus>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        dist[START] = 0;

        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.add(new Bus(START, 0));
        while (!queue.isEmpty()) {
            Bus current = queue.poll();

            if (dist[current.destination] < current.cost) {
                continue;
            }

            for (Bus next : graph.get(current.destination)) {
                if (dist[next.destination] > dist[current.destination] + next.cost) {
                    dist[next.destination] = dist[current.destination] + next.cost;
                    queue.add(new Bus(next.destination, dist[next.destination]));
                }
            }
        }

        System.out.println(dist[END]);


    }

    static class Bus implements Comparable<Bus>{
        int destination;
        int cost;

        public Bus(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(cost, o.cost);
        }
    }
}
