import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Good_1253 {
	static int N, answer;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		input_output();
	}
	
	static void input_output() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		while(N-- > 0) {
			A[cnt] = Integer.parseInt(st.nextToken());
			cnt++;
		}
		
		br.close();
		
		for(int i=0; i<N; i++) {
			if(two_pointer(i)) answer++;
		}
		
		System.out.println(answer);
	}
	
	static boolean two_pointer(int idx) {
		int left = 0, right = 0, target = A[idx];
	
		while(left < right) {
			
			if(A[left] + A[right] == target) return true;
		}
		
		return false;
	}
	
}
