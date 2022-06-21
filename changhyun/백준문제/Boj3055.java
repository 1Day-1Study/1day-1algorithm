package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static char[][] map;
    static int[][] isVisited;
    static Queue<Position> queue = new LinkedList<>();
    static int[] tx = {0, 0, -1, 1};
    static int[] ty = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new int[R][C];


        // 맵 초기화
        Position beaverPosition = new Position();
        int gul_y = 0;
        int gul_x = 0;
        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j].charAt(0);
                if (map[i][j] == '*') {
                    queue.add(new Position(i, j, '*'));
                }
                if (map[i][j] == 'S') {
                    beaverPosition.setPosition(i, j, 'S');
                }
                if (map[i][j] == 'D') {
                    gul_y = i;
                    gul_x = j;
                }
            }
        }

        queue.add(beaverPosition);

        while (!queue.isEmpty()) {
            //큐에서 꺼내기
            Position current = queue.poll();

            //목적지인가?
            if (current.y == gul_y && current.x == gul_x) {
                System.out.println(isVisited[current.y][current.x]);
                return;
            }

            //연결된곳 순회
            for (int i = 0; i < 4; i++) {
                int ny = current.y + ty[i];
                int nx = current.x + tx[i];

                //갈수있는가?
                // 맵영역인가?
                if (isInMap(ny, nx)) {
                    // 돌인가?
                    if (isNotStone(ny, nx)) {
                        if (current.type == 'S') {
                            if (map[ny][nx] == '.' || map[ny][nx] == 'D') {
                                if (isVisited[ny][nx] == 0) {
                                    queue.add(new Position(ny, nx, 'S'));
                                    isVisited[ny][nx] = isVisited[current.y][current.x] + 1;
                                }
                            }
                        } else if (current.type == '*') {
                            if (map[ny][nx] == '.') {
                                queue.add(new Position(ny, nx, '*'));
                                map[ny][nx] = '*';
                            }
                        }


                    }
                }

            }
        }

        System.out.println("KAKTUS");
    }

    static class Position {
        int y;
        int x;
        char type;

        public Position() {
        }

        public Position(int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        public void setPosition(int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static boolean isInMap(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }

    static boolean isNotStone(int y, int x) {
        return !(map[y][x] == 'X');
    }

}
