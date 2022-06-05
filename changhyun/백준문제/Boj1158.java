package 백준문제;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 큐에 1부터 N까지 집어넣기
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (true) {
            //가로를 닫기 위해서 큐 사이즈가 1이면 가로 닫고 while문 종료
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
                break;
            }

            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");

        }

        System.out.println(sb.toString());
    }
}
