package suyeon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//단지번호 붙이기
public class Boj2667 {

        static ArrayList<Integer> arr; //집의 개수를 담는다. (arr.size()가 단지의 개수)
        static int[][] map; //지도(0, 1)을 담는다.
        static boolean[][] visited; //방문여부
        static int n; //입력받을 지도의 크기

        static class Loc{
            int i;
            int j;

            public Loc(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            //단지들이 있는 지도의 크기
            map = new int[n][n];
            //방문여부
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                
                String tmp = br.readLine();
                
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
                    //시작하는 부분 true 방문하고 시작하기
                    if(map[i][j]==0){
                        visited[i][j] = true;
                    }
                }
            }

            arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        bfs(i, j);
                    }
                }
            }
            //단지 내의 집을 오름차순으로 정렬
            Collections.sort(arr);
            //단지 개수
            System.out.println(arr.size());
            //각 단지의 집의 개수
            for (int a : arr) {
                System.out.println(a);
            }

        }

        public static void bfs(int i, int j){

            int[] mi = {0, 0, -1, 1};
            int[] mj = {1, -1, 0, 0};

            Queue<Loc> q = new LinkedList<>();
            //큐에 지도 i, j 좌표를 담는다.
            q.add(new Loc(i, j));
            //방문여부
            visited[i][j] = true;
            //집의 개수
            int cnt = 0;

            while (!q.isEmpty()) {

                Loc now = q.poll();
                cnt++;

                for (int d = 0; d < 4; d++) { // 상하좌우 인접한 집이 있는지 확인

                    int ni = now.i + mi[d];
                    int nj = now.j + mj[d];
                    System.out.println("ni = " + ni + "/ nj = " + nj);

                    if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;

                    if (!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        q.add(new Loc(ni, nj));
                    }
                }

            }
            System.out.println("cnt = "+cnt);
            //각 집의 개수들이 (ex. 7,8,9)가 담긴다.
            arr.add(cnt);
        }
    }