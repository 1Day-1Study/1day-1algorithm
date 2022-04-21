package doyoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BigO_17298 {

	public static void main(String[] args) throws IOException{
//문제 접근 방식 
//수열을 탐색하면서 현재 원소가 이전의 원소보다 작을 때 까지 stack에 수열의 index를 stack에 
//추가(push)하는 것이다. 그리고 만약 현재 원소가 스택의 top원소를 인덱스로 하는 수열의 원소보다 
//크게 될 경우 stack의 원소를 pop하면서 해당 인덱스에 해당하는 원소들을 현재 원소로 바꿔주는 것이다.
	
	//1.입력	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Stack<Integer> stack = new Stack<Integer>();
	
	//2.입력한 크기로 배열만들기  
	int n = Integer.parseInt(br.readLine());
	int[] seq = new int[n];
	
	//3.공백을 기준으로 문자열을 쪼개라.
	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
	//4.토큰읽어와서 담아주기. 
	for(int i =0; i<n; i++) {
		seq[i] = Integer.parseInt(st.nextToken());
	}
	//int [] seq 완성!. 
	
//	5.스택이 비어있지 않으면서 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
//	해당 조건을 만족할 때 까지 stack의 원소를 pop하면서 
//	해당 인덱스의 값을 현재 원소로 바꿔준다.
	for(int i=0; i<n; i++) {
		while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
			seq[stack.pop()] =seq[i];
		}
		stack.push(i); //스텍이 비어있다면 (첫 원소의 경우 또는 스택의 맨 원소가
		                //가리키는 원소보다 작은 경우) 
	}
//	6.스택에 남아있는 모든 원소를 꺼내면서 해당 인덱스의 값을 -1로 바꿔준다.
	while(!stack.isEmpty()) {
		seq[stack.pop()] = -1;
	}
	
	//7.출력하기
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	for(int i =0; i<n; i++) {
		bw.write(seq[i]+" ");
	}
	bw.flush();
	bw.close();
}
}
