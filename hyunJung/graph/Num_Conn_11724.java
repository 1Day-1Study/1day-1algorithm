import java.util.Scanner;

/*
 * 문제번호 : 11724
 */

public class Num_Conn_11724 {
	
	static int N, M; // N = 노드의 개수, M = 간선의 개수
	static int[][] adj;
	
	static boolean[] visit;

	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		adj = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt(); int y = sc.nextInt();
			
			adj[x][y] = 1;
			adj[y][x] = 1;
			
		}
	}
	
	static void search() {
		int cnt = 0;
		
		for(int i = 1; i < N+1; i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++; // 방문배열을 확인하면서, 정점이 있으면 탐색하고 연결요소 개수 증가
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int node) {
		visit[node] = true;
		
		//방문배열 처음부터 돌면서, 간선이 연결되어 있고,방문하지 않았으면 dfs 진행 
		for(int i = 1; i <= N; i++) {
			if(adj[node][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		search();
	}
}
