import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int cnt;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		cnt = 0;
	}
	
	Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Knight_7562 {
	
	static int[] dirX = { -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dirY = { -2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		// test case 
		int T_Case = Integer.parseInt(br.readLine());
		
		// get locations
		while(T_Case-- > 0) {
			// 체스판 크기
			int I = Integer.parseInt(br.readLine());
			int[][] plate = new int[I][I];
			
			// now - goal
			Point[] points = new Point[2];
			
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				points[i] = new Point(start, end);
			}
			
			sb.append(BFS(plate, points, I)).append("\n");
		}
		
		bw.write(sb.toString());
		
		// close
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int BFS(int[][] plate, Point[] points, int I) {
		Queue<Point> que = new LinkedList<>();
		
		que.offer(points[0]); // now location
		
		boolean[][] visit = new boolean[I][I];
		visit[points[0].x][points[0].y] = true; // check current location
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			// end searching
			if(p.x == points[1].x && p.y == points[1].y) {
				return p.cnt;
			}
			
			// 8 cases to move
			for(int i=0; i<8; i++) {
				int dx = p.x + dirX[i];
				int dy = p.y + dirY[i];
				
				// out of the range
				if(dx < 0 || dy < 0 || dx >= I || dy >= I) {
					continue;
				}
				
				if(!visit[dx][dy]) {
					visit[dx][dy] = true;
					que.offer(new Point(dx, dy, p.cnt + 1));
				}
			}
		}
		
		return -1;
	}

}
