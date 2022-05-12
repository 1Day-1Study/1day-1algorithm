import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_and_M_9_15663 {

	static int N, M;
	
	static boolean[] visit; // flag
	static int[] temp; // selected set-numbers
	static int[] numbers; // input numbers
	
	static StringBuilder answer = new StringBuilder(); 
	
	public static void main(String args[]) throws IOException {
		input();
		dfs(N, M, 0);
		
		System.out.println(answer);
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N]; // flag
		temp = new int[M];
		
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers); // 정렬
		System.out.println(Arrays.toString(numbers));
	}
	
	static void dfs(int N, int M, int depth) {
		if(depth == M) {
			// print
			for(int val : temp) {
				answer.append(val).append(' ');
			}
			answer.append("\n");
			return;
		}
		
		// N개의 숫자 선택
		int before = 0;
		for(int i=0; i<N; i++) {
			if(visit[i]) {
				continue;
			}else if(before != numbers[i]) {
				visit[i] = true;
				temp[depth] = numbers[i];
				before = numbers[i];
				// 재귀호출
				dfs(N, M, depth + 1);
				// flag 원상태로 복구
				visit[i] = false;
			}
		}
	}
}
