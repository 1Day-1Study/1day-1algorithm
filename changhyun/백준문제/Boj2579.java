package 백준문제;

public class Boj2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] score;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        score = new int[N + 1];
        dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = score[1];

        // 0 10 20 15 25 10 20
        // 0 10 30 35 50 65 65 dp[i][0](g(i))
        // 0  0 20 25 55 45 75 dp[i][1](h(i))

        for (int i = 2; i <= N; i++) {

            // g(i) = h(i-1) + score(i)
            dp[i][0] = dp[i - 1][1] + score[i];

            // h(i) = max(g(i-2), h(i-2) + score[i]
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));

    }
}
