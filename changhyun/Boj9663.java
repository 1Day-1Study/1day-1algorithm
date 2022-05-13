import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9663 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(count);

    }

    static void dfs(int cur) {
        if (cur == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isused1[i] || isused2[i + cur] || isused3[cur - i + N - 1]) {
                continue;
            }
            isused1[i] = true;
            isused2[i + cur] = true;
            isused3[cur - i + N - 1] = true;
            dfs(cur + 1);
            isused1[i] = false;
            isused2[i + cur] = false;
            isused3[cur - i + N - 1] = false;
        }
    }
}
