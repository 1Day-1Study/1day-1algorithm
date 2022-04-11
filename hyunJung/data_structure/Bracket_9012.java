package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bracket_9012 {
	/*
	 *  the number of '(' == the number of ')'
	 *  count up, '('
	 *  count down, ')'
	 *  0 = YES, !0 = NO
	 */
	
	public static void main(String[] args) throws IOException {
		//io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T>0) {
			//sb.append("result > ").append(solution(br.readLine())).append("\n");
			sb.append(solution(br.readLine())).append("\n");
			T--;
		}
		
		System.out.println(sb);

	}
	
	public static String solution(String brackets) {
		
		int cnt = 0;
		
		for(char c: brackets.toCharArray()) {
			if(c=='(') {
				cnt++;
			}else if(cnt==0) {
				return "NO";
			}else {
				cnt--;
			}
		}
		
		if(cnt == 0) {
			return "YES";
		}else {
			return "NO";
		}
		
		
	}

}
