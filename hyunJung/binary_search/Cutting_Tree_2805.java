import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cutting_Tree_2805 {
    static int N, M, H;
    static int[] tree;
    
    public static void main(String[] args) throws IOException{
    	input();
    	binary();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        tree = new int[st.countTokens()];

        for(int i=0; st.hasMoreElements(); i++) {
        	tree[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }
    
    static void binary() {
    	Arrays.sort(tree);
    	
    	long end = tree[tree.length-1], start = 0;
    	// long end = 2000000000, start = 0; 라이브러리를 쓰지 않아서 훨씬 빠름 
    	while(end-start>=0) {
    		int mid = (int) (end+start)/2;
    		if(determination(mid)) { // 정답, 
    			H = mid;
    			start = mid + 1;
    		}else {
    			end = mid - 1;
    		}
    	}
    	
    	System.out.println(H);
    }
    
    static boolean determination(int mid) {
    	
    	long sum = 0;
    	
    	for(int i=0; i<tree.length; i++) {
    		if(tree[i] > mid) sum += tree[i] - mid;
    	}
    	
    	return sum >= M;
    }
    
    
}