package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15650 {
    static boolean[] visited;
    static int N, M;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        backTracking(0, 1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void backTracking(int length, int start) {
        if (length == M) {
            list.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i);
                sb.append(" ");
                backTracking(length + 1, i);
                visited[i] = false;
                sb = sb.delete(sb.length() - 2, sb.length());
            }
        }
    }
}
