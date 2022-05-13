import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj15663 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] seq;
    static boolean[] isVisited;
    static Set<String> dupCheck = new TreeSet<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, "");

        for (String s : dupCheck) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int length, String temp) {
        if (length == M) {
            dupCheck.add(temp.trim());
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(length + 1, temp + " " + seq[i]);
                isVisited[i] = false;
            }
        }
    }
}
