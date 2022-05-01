package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 재귀함수 개념을 이용
 * 반복문을 사용해도 풀이 가능
 */

public class Factorial_10872 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int answer = getFactorial(N);
		
		System.out.println(answer);
		
	}
	
	static int getFactorial(int N) {
		if(N <= 1) return 1;
		return N * getFactorial(N-1);
	}
}
