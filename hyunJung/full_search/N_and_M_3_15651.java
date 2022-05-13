import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_and_M_3_15651 {

    static int N, M;
    static int[] select;

    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(answer);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        select = new int[M];
        
        dfs(1, 0);
    }
    
    static void dfs(int at, int depth) {
    	if(depth == M) {
    		// print
    		for(int val : select) {
    			answer.append(val).append(' ');
    		}
    		answer.append("\n");
    		return;
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		select[depth] = i; // select 1st number
    		dfs(i, depth + 1); // select 2nd number -> able to overlap -> start from 1
    	}
    }
}