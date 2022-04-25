import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = gcd(a, b);
            sb.append(gcd * (a / gcd) * (b / gcd)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b != 0) {
            return gcd(b, a % b);
        }

        return a;
    }
}
