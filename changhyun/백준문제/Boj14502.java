package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static List<Virus> virusList = new ArrayList<>();
    static int[] ti = {-1, 1, 0, 0};
    static int[] tj = {0, 0, -1, 1};
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }

        walling(0);

        System.out.println(maxSafeZone);

    }

    static void walling(int cnt) {

        if (cnt == 3) {

            // 배열 복사
            int[][] virusMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    virusMap[i][j] = map[i][j];
                }
            }

            spreadVirus(virusMap);

            int safeZone = checkSafeZone(virusMap);
            maxSafeZone = Math.max(maxSafeZone, safeZone);

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    walling(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus(int[][] virusMap) {

        Queue<Virus> queue = new LinkedList<>(virusList);

        while (!queue.isEmpty()) {
            Virus current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ni = ti[i] + current.i;
                int nj = tj[i] + current.j;

                if (inArea(ni, nj) && virusMap[ni][nj] == 0) {
                    virusMap[ni][nj] = 1;
                    queue.add(new Virus(ni, nj));
                }
            }

        }

    }

    static boolean inArea(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }

    static int checkSafeZone(int[][] virusMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Virus {
        int i;
        int j;

        public Virus(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
