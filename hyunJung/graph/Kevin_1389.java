import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * Floyd Warshall algorithm
 * ref >>> https://blog.naver.com/ndb796/221234427842
 */

public class Kevin_1389 {

	// Floyd Warshall, 모든 배열의초기화 설정값,  
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // the number of Users
		int M = Integer.parseInt(st.nextToken()); // Relationship
		
		int[][] network = new int[N+1][N+1];
		
		// Floyd Warshall setting
		for(int i=1; i<=N; i++) {
			for(int j=1; j<= N; j++) {
				network[i][j] = INF;
				
				if(i == j) {
					network[i][j] = 0;
				}
			}
		}
		
		// both-way line
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			network[x][y] = network[y][x] = 1; // connection = 1
		}
		
		// F-W algorithm
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					// update short-cut
					if(network[i][j] > network[i][k] + network[k][j]) {
						network[i][j] =network[i][k] + network[k][j];
					}
				}
			}
		}
		
		int res = INF;
		int idx = -1; // ?
		
		// find the answer 
		for(int i=1; i<=N; i++) {
			int total = 0;
			
			for(int j=1; j<=N; j++) {
				total += network[i][j];
			}
			
			if(res > total) {
				res = total;
				idx = i;
			}
		}
		
		bw.write(idx + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
