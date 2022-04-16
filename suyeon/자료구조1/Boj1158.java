package suyeon.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1158 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] testcase = br.readLine().split(" ");

        int N = Integer.parseInt(testcase[0]);
        int K = Integer.parseInt(testcase[1]);

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            que.offer(i+1); //for문은 0부터 시작하므로 +1해준다.
        }

        sb.append("<");

        //que 크기가 1일 때까지 반복
        while(que.size() != 1){
            //k-1(가장 맨 직전값)까지 맨 뒤로 보낸다
            for (int i = 0; i < K-1; i++) {
                que.offer(que.poll());

            }
            sb.append(que.poll()+", ");
        }
        //que 사이즈는 1일때 마지막 남은 값 poll
        sb.append(que.poll() + ">");


        System.out.println(sb.toString());


    }
}
