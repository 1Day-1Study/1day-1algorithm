package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach_6588 {

	static boolean[] prime = new boolean[10000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 소수 판별
		get_prime();

		int n = 0;

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n != 0) {

				int first_num = n / 2;
				int second_num = n / 2;

				while (true) {
					if (!prime[first_num] && !prime[second_num]) {
						sb.append(n).append(" = ").append(first_num).append(" + ").append(second_num).append("\n");
						break;
					}

					first_num--;
					second_num++;
				}
			} else {
				break;
			}
		}
		br.close();
		System.out.println(sb);
	}

	// 에라토스테네스의 체
	static void get_prime() {

		// 0, 1은 소수가 아님
		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;

			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

	}
}
