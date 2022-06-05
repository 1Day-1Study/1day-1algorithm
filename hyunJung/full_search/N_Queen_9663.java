import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9663 {
	
	static int cnt = 0;
	static int[] col;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		col = new int[N];
		
		dfs(0, N);
		System.out.println(cnt);
	}
	
	static void dfs(int row, int N) {
		if(row == N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			col[row] = i;
			
			if(isPossible(row)) {
				dfs(row + 1, N);
			}
		}
	}
	
	static boolean isPossible(int row) {
		for(int i=0; i<row; i++) {
			if(col[i] == col[row] || Math.abs(i-row) == Math.abs(col[i]-col[row])) return false;
		}
		
		return true;
	}
	
}
