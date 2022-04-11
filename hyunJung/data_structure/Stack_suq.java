package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * @author hyunjungkim
 * 
 *
 */
public class Stack_suq {
			
	public static void main(String[] args) throws IOException {
		
		int N;
		
		Stack<Integer> series = new Stack<>();
		
		int start = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				for(int i=start+1; i<=value; i++) {
					series.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			}else if(series.peek()!= value) {
				System.out.println("NO");
				break;
			}
			
			series.pop();
			sb.append('-').append('\n');
		}
		
		System.out.println(sb);
		
	}
	
}
