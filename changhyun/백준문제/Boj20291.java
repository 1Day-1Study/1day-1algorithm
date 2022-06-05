package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Boj20291 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new TreeMap<>();
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String ext = br.readLine().split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }

        for (String s : map.keySet()) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
