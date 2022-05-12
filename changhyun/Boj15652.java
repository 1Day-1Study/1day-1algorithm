import java.io.*;
import java.util.StringTokenizer;

public class Boj15652 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backTracking(0, 0, "");

        bw.write(sb.toString());
        bw.flush();
    }

    static void backTracking(int length, int last, String temp) {
        if (length == M) {
            sb.append(temp.trim()).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (last <= i) {
                backTracking(length + 1, i, temp+" "+i);
            }
        }
    }
}
