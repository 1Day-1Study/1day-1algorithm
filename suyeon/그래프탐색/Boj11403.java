package suyeon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//경로구하기 (플로이드와샬알고리즘)
public class Boj11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int adj[][] = new int[n][n];

        //n x n 행렬만들기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플로이드-와샬
        // i에서 j로 갈 때, k를 거쳐서 가는 경우가 있는지 확인한다.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(adj[i][k] == 1 && adj[k][j] == 1){
                        adj[i][j] = 1;
                    }
                }
            }
        }

        //i에서 j로 가는 경로를 출력한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

    }
}
