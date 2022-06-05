package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static Map<String, Integer> people = new HashMap<>();
    static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            people.put(name, 1);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (people.getOrDefault(name, 0) > 0) {
                cnt++;
                resultList.add(name);
            }
        }

        Collections.sort(resultList);

        sb.append(cnt).append("\n");
        for (String name : resultList) {
            sb.append(name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
