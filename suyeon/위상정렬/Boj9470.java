package suyeon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Strahler 순서
public class Boj9470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, M, P; //테스트케이스번호, 정점 개수, 간선 개수
    static int[] inDegree, maxCnt, order; //진입차수 개수, 강의 개수, 진입순서
    static ArrayList<Integer>[] graph; //인접리스트를 만들 ArrayList

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            inDegree = new int[M + 1];
            maxCnt = new int[M + 1];
            order = new int[M + 1];

            graph = new ArrayList[M + 1];

            for (int i = 1; i <= M; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                inDegree[b]++;
            }
            topologySort();
        }
        System.out.println(sb.toString());
    }

    static void topologySort(){
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= M ; i++) {
            //진입차수가 0인 정점부터 큐에 담는다.
            if (inDegree[i] == 0) {
                que.add(i);
                order[i]++; //강은 1부터 시작이기 때문이다.
                maxCnt[i]++;
            }
        }

        int result = 0;

        while (!que.isEmpty()){
            int start = que.poll();
            //자신을 향하는 간선이 2개 이상이면 순서를 증가시켜준다 (다음 진입차수가 되는 것)
            if (maxCnt[start] >= 2) order[start]++;
            // 가장 큰 값을 result로
            result = Math.max(result, order[start]);

            for (int next : graph[start]) {
                inDegree[next]--; //해당 간선 --
                //정점으로 향하는 간선이 없을 때,
                if (inDegree[next] == 0) que.add(next);
                //동일한 순서의 정점 방문
                if (order[next] == order[start]) maxCnt[next]++;
                else if (order[next] < order[start]) {
                    order[next] = order[start];
                    maxCnt[next] = 1;
                }
            }
        }
        sb.append(K).append(" ").append(result).append('\n');
    }
}
