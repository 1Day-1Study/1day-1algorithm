import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 소수면 true, 소수가 아니면 false인 boolean배열
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[1] = true;

        // 2부터 N까지 소수구하기
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= N ; j+=i) {
                isNotPrime[j] = true;
            }

        }

        // M부터 N까지 소수면 출력
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());


    }
}
