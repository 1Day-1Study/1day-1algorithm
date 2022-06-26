package suyeon.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen
public class Boj9663 {
    public static int N;
    public static int count;
    public static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        col = new int[N]; // N * N 행렬이기에 열도 인덱스를 N 까지 갖을 수 있게 한다.

        // 각 행에는 하나의 열에만 퀸이 놓여질 수 있다.
        // 1 열부터 N열까지 돌면서 각 1행 N열에 퀸을 놓았을때 가능한 경우를 확인한다.
        dfs(0);

        System.out.println(count);
    }
    // row 행까지는 퀸을 놓았다.
    // 만약 row 값이 N 과 같다면 N 행까지 퀸을 놓았다는 말이므로 count를 1 증가시켜준다.
    public static void dfs( int row) {
        if(row == N) {//column을 다 채웠으면 퀸 배치가 끝났으니까 count+1
            count++;
            return;
        }
        // 1열 부터 N 열까지 반복하면서 (row)에 퀸을 놓을 수 있는경우가 있는지 확인한다.
        // 있으면 다음행의 dfs를 호출한다.
        for(int i = 0; i < N; i++) { //퀸을 0번부터 N-1번까지 놓는 경우를 전부 따져본다.
                col[row] = i;//퀸을 i행에 놓는다.

                if(isPossible(row)) { //퀸을 i에 놓은것이 가능한가?
                    dfs(row + 1);//그렇다면 퀸을 그 자리에 넣고 다음 행으로 진입
                }
        }
    }

    public static boolean isPossible( int row) {
        // 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
        // 서로 공격할 수 없으려면
        // 1, 일직선 상에 퀸이 있으면 안 된다.
        // 2, 대각성 상에 퀸이 있으면 안 된다.(밑변 == 높이면 대각선 상에 있는 것)
        for(int i=0; i < row; i++) {
            // i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다.
            // 또는 i 행과 row 행의 열값이 대각선에 위치하는 절대값이면 안된다.
            if(col[i] == col[row] || Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
        }
        return true;
    }
}
