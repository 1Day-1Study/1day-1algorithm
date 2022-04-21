package doyoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class IronRod_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// read한 파일 공백단위로 끊어서 데이터에 넣기.
		String[] n = br.readLine().split("");

		Stack<String> stack = new Stack<>();

		int answer = 0;
		for (int i = 0; i < n.length; i++) {
			String now = n[i];

			if (now.equals("("))
				stack.push(now);
			else {
				if (n[i - 1].equals("(")) {
					stack.pop();
					answer += stack.size();
				} else {
					answer++;
					stack.pop();
				}
			}
		}
		bw.write(String.valueOf(answer)); //버퍼에 있는 값 전부 출력
		bw.flush(); //남아있는 데이터들 모두 출력
		bw.close(); //스트림을 닫음 
	}

}
//풀이방식 
