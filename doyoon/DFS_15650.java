package doyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_15650 {
	//N과 M은 값이 변경될 일이 없으므로 메소드 바깥에 선언해둔다. 
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		//출력과 문자열 분리를 위해 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1,0);
		System.out.println(sb);
		
	}
	public static void dfs(int as, int depth) {
		//깊이가 M과 같을 경우 출력해준다. 
		if(depth==M) {
			for(int val : arr) {
				sb.append(val).append(' ');
				
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i = as; i<= N; i++) {
		//현재 깊이를 index에 적고 해당 위치에 i 값을 담는다. 
			
			arr[depth] = i;
		//현재 i값보다 다음 재귀에서 커야하므로 i+1의 값을 넘겨주고 
		//깊이 또한 1 증가시켜 재귀 호출한다. 
			
			dfs(i+1, depth+1);
		}
	}

}
