import java.util.Scanner;

/*
 * no. 3584
 * 
 */

public class Nearest_Common_Anscestor_3584 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int N;
	static int[] parent;
	static boolean[] visit;
	
	static void input() {
		N = sc.nextInt();
		
		parent = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<N; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			parent[b] = a;
		}
	}
	
	
	static void search() {
		int x = sc.nextInt(); int y = sc.nextInt();
		
		while(x > 0) {
			visit[x] = true;
			x = parent[x];
		}
		
		while(y > 0) {
			if(visit[y]) {
				System.out.println(y);
				break;
			}
			
			y = parent[y];
		}
	}
	
	public static void main(String[] args) {
		int t_case = sc.nextInt();
		
		while(t_case-- > 0) {
			input();
			search();
		}
	}

}
