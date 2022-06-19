package suyeon.그래프탐색;

import java.util.Scanner;

//섬의 개수
public class Boj4963 {
    static int w,h,cnt;
    static int map[][];
    static boolean visits[][];
    static int dx[] = {1,-1,0,0,1,1,-1,-1};
    static int dy[] = {0,0,1,-1,1,-1,1,-1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            //섬의 크기 높이, 넓이
            h = sc.nextInt();
            w = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }
            //섬의 개수
            cnt = 0;

            map = new int [w+2][h+2]; // i, i+1, i-1 을 고려하여 배열 크기 지정
            visits = new boolean [w+2][h+2];

            //섬의 크기 만큼, 1과 0을 입력받아 map에 담는다.
            for(int i=1; i<=w; i++) {
                for(int j=1; j<=h; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            //이중 for문을 돌면서, 섬의 개수를 확인한다.
            for(int i=1; i<=w; i++) {
                for(int j=1; j<=h; j++) {
                    if(!visits[i][j] && map[i][j]==1) {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    private static void dfs(int x, int y) {
        visits[x][y] = true;
        //해당 위치에서 대각선+사방(8개)의 블럭을 확인
        for(int i=0; i<8; i++) {
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            if(!visits[new_x][new_y] && map[new_x][new_y] == 1) {
                dfs(new_x, new_y);
            }
        }
    }

}