package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = gcd(A, B);
        int lcm = gcd * (A/gcd) * (B/gcd);

        System.out.println(gcd(A, B));
        System.out.println(lcm);
    }

    static int gcd(int n, int m) {
        // n >= m 일 때 호제법이 성립하므로 m이 더 크다면 앞으로 바꿔준다.
        if (n < m) {
            return gcd(m, n);
        }
        if (m != 0) {
            return gcd(m, n % m);
        }
        return n;
    }
}

