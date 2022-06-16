package doyoon;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab_14502 {
    //1.벽을 3개 세운다. 
	//2.바이러스를 퍼뜨린다. 
	//3.최대 안전영역(0의갯수)를 구한다
	// --> 이 값을 max 값과 계속 비교하면서 최대값을 구한다. 
	
	public static int X; // X= M 
	public static int Y; // Y= N 
	public static int map[][];
	public static int max = 0;
	
	
	public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
	
    Y = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    map = new int[X][Y];
    //0. map 을 (x,y)상태로 보기 위해서 X,Y 로 받아준다.
    
    //0.1 맨 윗줄이 y값이 Y-1 좌표부터 시작하므로 (높은것부터 점점 낮아져야 한다)
    for (int y = Y-1; y >=0; y--) {
    //0.2 왼쪽부터 x값을 받으니까 0부터 시작한다. 
    	st = new StringTokenizer(br.readLine());
		for (int x = 0; x < X; x++) {
			map[x][y]= Integer.parseInt(st.nextToken());
		} 
	}
    recursive(0);
    System.out.println(max);
	
	}
	//1. 벽을 3개 세운다 = 완전탐색 재귀 사용 
	
	public static void recursive(int index) {	
		if(index ==3) {
			//1.2 바이러스를 퍼뜨려 본다. == bfs 를 사용하라.  
			//1.3 남아있는 0의 갯수를 샌다. 
			int countOf0 = bfs();
			//1.4 남아있는 0의 갯수의 최댓값을 계속 갱신한다. 
			max = Math.max(max, countOf0);
			return;
		}
	//1.1 벽 3개를 만들어주고  위 if문에서 max값을 구한 다음 벽 부수고  새로운 경우의 수를 계속 탐색한다. 
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1; //벽 만들기
					recursive(index+1);
					map[i][j] = 0; //벽 부수기 
					
				}
			}
		}
	}
	//2차원 에서 BFS 활용하기 위해 현재 좌표 기록하기. 
	public static int dx[] = new int[] {0,0,1,-1}; //상 하 오 왼
	public static int dy[] = new int[] {1,-1,0,0}; //상 하 오 왼 
	
	//2. 바이러스 퍼뜨리기
	public static int bfs() {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		boolean[][] visited = new boolean[X][Y];
		
		//2.1 바이러스가 2부터 뻗어나가므로 2를 q 에 넣어준다.
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if(map[i][j]==2) {
					q.add(new int[] {i,j});
		//2.2  2를 들렸음을 check 해준다. 
					visited[i][j]= true;
				}
			}
		}
		//2.3  바이러스를 다 꺼내올때까지 반복한다. 
		while(!q.isEmpty()) {
			//q.poll -> 가장 먼저 보관한 값을 꺼내고 반환한다. 
			int list[] = q.poll(); 
			//2.4 현재 위치 등록 (curx = current x) 
			int curx = list[0];
			int cury = list[1];
			
			//2.5 다음위치로 퍼지는데 4방향이 가능하므로 4공간까지 반복문 돌린다.
			for (int i = 0; i < 4; i++) {
			//2.6 위치를 이동해준다. 
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				//2.7
				//(1)현재 위치는 map 의 크기안에 들어가야 함 0 <= nx < X 
				                             //0 <= ny < Y
				//(2)방문했던 q는 제외해주어야 한다. --> visited = false
				//(3)벽(1)이 있는 공간도 제외해야 한다. --> map == 0
				// ** 이 조건에 충족하는 경우 바이러스가 퍼질 수 있다!
				
				if(0<=nx && nx< X && ny>=0 && ny < Y &&
						visited[nx][ny]==false && map[nx][ny]==0) {
					visited[nx][ny] = true; 
				//2.8 q에 넣었으므로 퍼진다. 
					q.add(new int[] {nx,ny}); 
					
				}
			}
		}
		//3.안전 영역의 갯수 구하기 
		int count = 0;
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				//3.1 0 이면서 바이러스가 들리지 않은 곳 = 안전영역
				if(map[i][j]==0 && visited[i][j]==false) {
					count++;
				}
			}
		}
		return count;
	}
    
}

























