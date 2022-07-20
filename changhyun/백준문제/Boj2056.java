package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2056 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] inDegree;
    static int[] times;
    static int[] workingTimes;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        times = new int[N + 1];
        workingTimes = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            workingTimes[i] = times[i];
            int precedingCnt = Integer.parseInt(st.nextToken());
            if (precedingCnt != 0) {
                inDegree[i] = precedingCnt;
                for (int j = 0; j < precedingCnt; j++) {
                    int precedingWork = Integer.parseInt(st.nextToken());
                    graph.get(precedingWork).add(i);
                }
            }
        }

        int totalWorkingTime = getTotalWorkingTime();
        System.out.println(totalWorkingTime);
    }

    static int getTotalWorkingTime() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : graph.get(current)) {
                workingTimes[next] = Math.max(workingTimes[next], workingTimes[current] + times[next]);
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int maxWorkingTime = Integer.MIN_VALUE;
        for (int workingTime : workingTimes) {
            maxWorkingTime = Math.max(maxWorkingTime, workingTime);
        }

        return maxWorkingTime;
    }
}
