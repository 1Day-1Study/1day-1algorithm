package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //소수가 아니면 true, 소수면 false
        boolean[] isNotPrime = new boolean[1001];

        // 0과 1은 소수가 아니므로
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // N의 최댓값인 1000의 제곱근까지만 진행
        for (int i = 2; i <= Math.sqrt(1000); i++) {

            //이미 체크가 되어있으면 지나가기
            if (isNotPrime[i]) {
                continue;
            }

            // N의 최댓값인 1000까지 중 소수가 아닌 수 구하기
            for (int j = i * i; j <= 1000; j += i) {
                isNotPrime[j] = true;
            }

        }

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!isNotPrime[n]) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
