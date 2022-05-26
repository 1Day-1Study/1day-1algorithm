package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2512 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] amounts;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        amounts = new int[N];

        // 모든 예산요청이 배정될 수 있는 경우를 처리하기 위해 모든 예산을 더한 변수
        int compareM = 0;

        // 굳이 정렬하지 않고 제일 큰 값을 찾기 -> Why? 0에서 큰값부터 만족하는 값을 찾기 위함이기 때문에 정렬된 데이터가 필요없다!
        int maxAmount = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            amounts[i] = Integer.parseInt(st.nextToken());
            maxAmount = Math.max(maxAmount, amounts[i]);
            compareM += amounts[i];
        }

        M = Integer.parseInt(br.readLine());

        // 모든 예산요청이 배정될 수 있으면 제일 큰 값 출력하고 끝
        if (compareM <= M) {
            System.out.println(maxAmount);
            return;
        }

        int left = 0;
        int right = maxAmount;

        while (left <= right) {

            int mid = (left + right) / 2;

            int sum = 0;
            for (int amount : amounts) {
                sum += Math.min(mid, amount);
            }

            if (M > sum) {
                left = mid + 1;
            } else if (M < sum) {
                right = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }

        }

        System.out.println(right);
    }
}
