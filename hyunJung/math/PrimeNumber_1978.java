package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumber_1978 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int cnt = 0;
		while (N-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			boolean t = checkPrime(num);
			
			if(t) cnt++;
		}
		
		System.out.println(cnt);
	}

	static Boolean checkPrime(int num) {
		// 1 is not prime number
		if (num == 1) {
			return false;
		}
		// 2 ~ num
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		
		return true;
	}

}
