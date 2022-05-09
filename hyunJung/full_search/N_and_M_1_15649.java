import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_and_M_1_15649 {
    static int N, M;
    static boolean[] visit; // 방문 플래그
    static int[] selected; // 선택한 번호를 담을 바구니
    
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	input();
    	dfs(N, M, 0);
    	System.out.println(answer);
    }

    // IO
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // range of numbers
        M = Integer.parseInt(st.nextToken()); // number of choice
        
        visit = new boolean[N]; // N=3, 1 ~ 3 사이의 수만 선택 가능
        selected = new int[M]; // M=2, 2개 선택 
    }
    
    // select function
    static void dfs(int N, int M, int depth) {
    	// M개 선택을 완료했으면 출력
    	if(depth == M) {
    		for(int val : selected) {
    			answer.append(val).append(" ");
    		}
    		answer.append("\n");
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
    		System.out.println(i+"방문 여부? " +visit[i]);
    		if(!visit[i]) { // i번째 노드에 아직 방문하지 않음 == false
    			visit[i] = true;
    			
    			selected[depth] = i + 1; // 0부터 시작이니까, +1
    			dfs(N, M, depth +1); // 재귀 호출 후
    			
    			visit[i] = false; // 다음 node에서 쓰기 위해서 false 
    		}
    	}
    	return;
    }
}