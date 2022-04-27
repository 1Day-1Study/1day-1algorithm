package math;

import java.util.Scanner;

public class PrimeNumber_1929 {

	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();

		for (int i = start; i <= end; i++) {
			checkPrime(i);
		}
		System.out.println(sb);
		
		sc.close();
	}

	static void checkPrime(int num) {
		Boolean flag = true;
		
		if (num == 1) { flag = false; }
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) { flag = false; }
		}

		if(flag == true) {
			sb.append(num).append("\n");
		}
	}
}
