package 백준문제;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15651 {
    static int N, M;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backTracking(0);

        for (String str : list) {
            bw.write(str+"\n");
        }

        bw.flush();

    }

    static void backTracking(int length) {
        if (length == M) {
            list.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(i);
            sb.append(" ");
            backTracking(length + 1);
            sb = sb.delete(sb.length() - 2, sb.length());
        }

    }
}
