package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class FlipWords_9093 {

	public static void main(String[] args) throws IOException {
		System.out.println("start");
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<Character>();
		// stack for saving words
		int cnt = Integer.parseInt(br.readLine());
		// variable for saving test number
		
		for(int i=0; i<cnt; i++) {
			char[] input = br.readLine().toCharArray(); // covert String into Array
			
			for(char c : input) {
				if(c != ' ') { // add a word
					stack.add(c);
				} else {
					while(!stack.empty()) {
						bw.write(stack.pop()); // FILO
					}
					bw.write(" ");
				}
			}
			while(!stack.empty()) {
				bw.write(stack.pop());
			}
			bw.write("\n");
		}
		bw.close();
		br.close();
		
	}
}
