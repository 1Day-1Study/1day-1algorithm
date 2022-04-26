package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_LMC_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = getGCD(a, b);
		int lmc = getLMC(a, b, gcd);
		
		System.out.println(gcd+"\n"+lmc);
	}
	
	static int getGCD(int a, int b) {
		
		while(b!=0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	static int getLMC(int a, int b, int r) {
		
		return (a*b)/r;
	}
}
