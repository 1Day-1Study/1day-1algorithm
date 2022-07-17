package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine()); //테스트케이스 갯수

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //건물의 갯수
            int K = Integer.parseInt(st.nextToken()); //건물간의 건설 순서 규칙 (간선)의 갯수

            // 각 건물당 건설에 걸리는 시간을 담기위한 배열
            int[] times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }

            // 건설 그래프를 담기 위한 인접 리스트
            List<List<Integer>> graph = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            // 진입차수를 저장하기 위한 배열
            int[] inDegree = new int[N + 1];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                inDegree[b]++;
            }

            int W = Integer.parseInt(br.readLine());

            getBuildingTime(graph, times, inDegree, N, W);

        }

        System.out.println(sb.toString());
    }

    static void getBuildingTime(List<List<Integer>> graph, int[] times, int[] inDegree, int N, int W) {

        // 위상정렬을 구현하기 위한 큐
        Queue<Integer> queue = new LinkedList<>();

        // 실제 건물을 건설 소요시간을 저장할 배열
        int[] buildingTimes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            buildingTimes[i] = times[i];
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : graph.get(current)) {
                // 해당 건물을 지으려면 이전 건물을 지어야지만 지을 수 있기 때문에
                // 이전 건물 건설 소요 시간중에 가장 오래걸린 것으로 하기위해 max 사용
                buildingTimes[next] = Math.max(buildingTimes[next], buildingTimes[current] + times[next]);
                inDegree[next]--;

                // 들어오는 차수가 0인 것을 큐에 넣기 (다음 탐색 대상)
                if (inDegree[next] == 0) {

                    //원하는 건물이면 정렬 멈춤
                    if (next == W) {
                        break;
                    }
                    queue.add(next);
                }
            }
        }
        sb.append(buildingTimes[W]).append("\n");
    }
}
