import java.io.*;
import java.util.StringTokenizer;

public class Boj15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[] isVisited; // 방문처리를 위한 boolean 배열

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 1];

        backTracking(0);

        bw.flush();
    }

    static void backTracking(int length) throws IOException {

        //목적지인가?
        if (length == M) {
            for (int i = 0; i < sb.length(); i++) {
                bw.write(sb.charAt(i)+ " ");
            }
            bw.newLine();
            return;
        }

        // 연결된 곳을 순회
        for (int i = 1; i <= N; i++) {

            // 갈수있는가? (방문한적이 있는가?)
            if (!isVisited[i]) {
                sb.append(i);
                isVisited[i] = true;
                backTracking(length + 1);
                isVisited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
