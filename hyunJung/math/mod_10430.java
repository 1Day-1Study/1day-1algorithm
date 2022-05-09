package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mod_10430 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(getMod(a, b, c));
	}
	
	static StringBuilder getMod(int a, int b, int c) {
		sb.append((a+b)%c).append("\n");
		sb.append(((a%c)+(b%c))%c).append("\n");
		sb.append((a*b)%c).append("\n");
		sb.append(((a%c)*(b%c))%c).append("\n");
		return sb;
	}
	
}
