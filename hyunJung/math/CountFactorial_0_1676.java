package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountFactorial_0_1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		while(N >= 5) {
			cnt += N/5;
			System.out.println("count > > > "+cnt);
			N /= 5;
			System.out.println("N ? ? ? "+N);
		}
		System.out.println(cnt);
	}
	
}
