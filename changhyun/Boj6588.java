import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj6588 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();

        //최댓값을 저장하기 위한 변수
        int maxNumber = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            maxNumber = Math.max(maxNumber, n);
            list.add(n);
        }

        boolean[] isNotPrime = new boolean[maxNumber + 1];

        for (int i = 2; i <= Math.sqrt(maxNumber); i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= maxNumber; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int i = 0; i < list.size(); i++) {

            // 두 홀수 소수의 합으로 나타낼 수 있는지 없는지
            boolean flag = false;
            Integer n = list.get(i);

            // 아리토스테네스 체의 대칭성을 이용한 로직
            for (int j = 3; j <= n / 2; j+=2) {
                if (!isNotPrime[j] && !isNotPrime[n - j]) {
                    flag = true;
                    sb.append(n + " = " + j + " + " + (n-j)).append("\n");
                    break;
                }
            }

            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.");
            }

        }

        System.out.println(sb.toString());

    }
}
