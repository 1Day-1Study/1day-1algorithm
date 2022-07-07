package suyeon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2552 {
    static int n; //학생의 수 = 간선(edge)의 개수
    static int m; //키 비교 횟수 = 그래프 정점(vertex)의 개수 = 노드(node)의 개수
    static int[] degree; //진입차수(자신을 향하는 화살표)
    static List<Integer>[] list; //연결리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        degree = new int[n + 1]; //진입차수(자신을 향하는 화살표)
        list = new ArrayList[n + 1]; //연결리스트

        //그래프 정점별로 연결된 정점을 기록할 리스트 초기화
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            degree[y]++;
        }
        // input end
        topologySort();
    }

    static void topologySort() {
        //위상정렬을 담을 큐
        Queue<Integer> queue = new LinkedList<>();
        //차수(degree)가 0인 학생들을 먼저 큐에 담는다.
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < list[current].size(); i++) {
                //진입차수가 0인 정점이 가르키는 연결된 정점들을 순차적으로 탐색한다.
                //연결된 정점들을 담은 후, 배열에서 제거해준다.
                int next = list[current].get(i);
                degree[next]--;
                //앞의 정점들이 사라지면, 차수가 0이 되게 되고 담기를 반복
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

    }
}
