import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        // 단순히 5로 나누는게 아니라 5로 나누면서 누적합!
        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }

        System.out.println(cnt);

    }
}
