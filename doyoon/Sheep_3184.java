package doyoon;

import java.util.*;
import java.io.*;

public class Sheep_3184 {
	
	//마당 , 방문체크, 총 양, 총 늑대 
	
	static int R, C;
	static char[][] yard;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int sheepTotal, wolfTotal;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		yard = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			yard[i] = br.readLine().toCharArray();
		}
		
		//울타리가 쳐있지 않은 구역의 시작을 기준으로 BFS 탐색을 한다. 
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (yard[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(sheepTotal + " " + wolfTotal);

	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		visited[x][y] = true;
		
		q.add(new int[] { x, y });
		
		int sheepCnt = 0, wolfCnt = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			//양의 수 세기 
			if (yard[now[0]][now[1]] == 'o')
				sheepCnt++;
			//늑대의 수 세기 
			else if (yard[now[0]][now[1]] == 'v')
				wolfCnt++;
			
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (!isRange(nx, ny) || visited[nx][ny] || yard[nx][ny] == '#')
					continue;

				visited[nx][ny] = true;
				q.add(new int[] { nx, ny });

			}
		}
		//양의 수가 크면 총 양에 더한다.
		if (sheepCnt > wolfCnt) {
			
			sheepTotal += sheepCnt;
		}
		//양의 수가 작거나 같으면 총 늑대에 더한다. 
		else {
			
			wolfTotal += wolfCnt;			
		}

	}

	//범위를 벗어나는지 여부를 보여준다. 
	static boolean isRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
