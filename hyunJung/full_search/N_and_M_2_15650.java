import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 예시를 보면 i+1번째 선택한 수는 i번째 선택한 수보다 클 수가 없음.
 * e.g) i = 1 -> i+n = 2, 3, 4
 */
public class N_and_M_2_15650 {
	static int N, M;
	
	static int[] select;
	static boolean[] visit;
	
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		input();
	}
	
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        System.out.println("- - - - - - ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        visit = new boolean[N];
        
        dfs(0, 0);
        System.out.println(answer);
        br.close();
    }
    
    static void dfs(int at, int depth) {
    	if(depth == M) {
    		for(int val : select) { 
    			answer.append(val).append(' ');
    		}
    		answer.append("\n");
    		return;
    	}
    	
    	for(int i=at; i<N; i++) {
    		if(!visit[i]) {
	    		select[depth] = i + 1; // select 1st
	    		visit[i] = true;
	    		dfs(select[depth], depth + 1); // select 2nd
	    		visit[i] = false;
    		}
    	}
    }

}
