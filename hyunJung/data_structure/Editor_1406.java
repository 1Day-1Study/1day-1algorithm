package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * @author hyunjungkim
 * 1. total commands are 4 cases
 * 2. commands is able to divide by 2 cases > left and right
 * 3. need 2 stacks
 * 4. if the command is about left > save in left stack
 * 5. if the command is about right > save in right stack
 * 6. to print result connect two stacks
 */
public class Editor_1406 {
	
	public static void main(String[] args) throws IOException{
		//io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input values
		String words = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		
		for(char c : words.toCharArray()) {
			leftStack.push(c);
		}
		
		while(M-- > 0) {
			String cmd = br.readLine();
			
			switch(cmd.charAt(0)) {
				case 'L':
					if(!leftStack.empty()) {
						rightStack.push(leftStack.pop());
					}else {
						break;
					}
					break;
				case 'D':
					if(!rightStack.empty()) {
						leftStack.push(rightStack.pop());
					}else {
						break;
					}
					break;
				case 'B':
					if(!leftStack.empty()) {
						leftStack.pop();
					}else {
						break;
					}
					break;
				case 'P':
					leftStack.push(cmd.charAt(2));
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!leftStack.empty()) {
			rightStack.push(leftStack.pop());
		}
		while(!rightStack.empty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb);
	}
}
