package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountFactorial_0_1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int factorial = getFactorial(N);
		
	}
	
	static int getFactorial(int N) {
		if(N <= 1) return 1;
		return N * getFactorial(N-1);
	}
}
