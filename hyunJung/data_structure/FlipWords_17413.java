package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class FlipWords_17413 {
	
	static Stack<Character> str = new Stack<Character>();
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
		
		String input = str.readLine() + "\n";
		
		System.out.println(check(input));
	}
	
	static StringBuilder check(String input) {
		char[] toChar = input.toCharArray();
		boolean flag = false; // 초기값, 꺾쇠 없음
		
		for(char c : toChar) {
			if(c=='<') flag = true;
			
			if(flag || c ==' ' || c == '\n') {
				while(!str.empty()) result.append(str.pop());
				if(c != '\n') result.append(c);
				System.out.println("printing case >>> "+result);
			} else {
				str.push(c);
			}
			
			if(c=='>') flag = false;
		}
		
		return result;
	}
	
}
