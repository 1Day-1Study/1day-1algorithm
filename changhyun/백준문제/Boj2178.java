package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Node> nodes = new LinkedList<>();
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] ty = {-1, 0, 1, 0};
    static int[] tx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        nodes.add(new Node(0, 0, 1));

        while (!nodes.isEmpty()) {

            //큐에서 빼오기
            Node current = nodes.poll();

            //목적지인가?
            if (current.y == N - 1 && current.x == M - 1) {
                System.out.println(current.dist);
                return;
            }

            // 네 방향을 돌면서 갈수있는가 체크
            for (int i = 0; i < 4; i++) {
                int nextY = ty[i] + current.y;
                int nextX = tx[i] + current.x;

                //갈수 있는가?
                if (canGo(nextY, nextX)) {

                    //큐에 넣기
                    nodes.add(new Node(nextY, nextX, current.dist + 1));

                    //방문체크
                    isVisited[nextY][nextX] = true;
                }
            }

        }


    }

    static boolean canGo(int y, int x) {
        return isInMap(y, x) && isOne(y, x) && isVisited(y, x);
    }

    // 맵 영역인가?
    static boolean isInMap(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    // 갈수있는 칸인가?
    static boolean isOne(int y, int x) {
        return map[y][x] == 1;
    }

    // 방문한 적이 있는가?
    static boolean isVisited(int y, int x) {
        return !isVisited[y][x];
    }

    static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
