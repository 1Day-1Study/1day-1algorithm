package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Iron_Bar_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Stack<Character> bracket = new Stack<>();
		
		//cnt 
		int stick = 0;
		
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if(c == '(') {
				bracket.push(c);
				System.out.println("push > > > "+bracket.size());
			}else {
				if(input.charAt(i-1) == '(') {
					bracket.pop();
					stick += bracket.size();
					System.out.println("laser ) = "+bracket.size()+", stick ? "+stick);
				} else {
					stick++;
					bracket.pop();
					System.out.println("stick ) = "+bracket.size()+", stick ? "+stick);
					
				}
			}
		}
		
		System.out.println("stick > "+stick);
	}
}
