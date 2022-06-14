package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] money;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];

        int maxMoney = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            maxMoney = Math.max(maxMoney, money[i]);

        }

        int left = maxMoney;
        int right = 1000000000;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (countWithdraw(mid) > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    static int countWithdraw(int mid) {
        int currentMoney = mid;
        int cnt = 1;

        for (int i = 0; i < N; i++) {

            // 인출 금액보다 소비 금액이 더 클때
            if (mid < money[i]) {
                return M + 1;
            }
            if (currentMoney < money[i]) {
                currentMoney = mid;
                cnt++;
                currentMoney -= money[i];
            } else {
                currentMoney -= money[i];
            }
        }

        return cnt;
    }
}
