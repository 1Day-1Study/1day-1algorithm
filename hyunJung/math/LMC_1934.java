package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LMC_1934 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer token; 
		
		String answer = "";
		
		while(N-- > 0) {
			token = new StringTokenizer(br.readLine(), " ");
			 
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			
			int lmc = getLMC(a, b);
			
			answer += Integer.toString(a*b/lmc) + "\n";
		}
		
		System.out.println(answer);
		
	}
	
	public static int getLMC(int a, int b) {
		
		while(b != 0) {
			int r = a % b;
			
			a = b;
			b = r;
		}
		
		return a;
	}
}

