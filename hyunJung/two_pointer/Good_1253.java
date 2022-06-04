import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		A = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A, 1, N+1);
		
		for(int i = 1; i <= N; i++) {
			if(two_pointer(i)) answer++;
		}
		
		System.out.println(answer);
		br.close();
	}
	
	static boolean two_pointer(int idx) {
		int left = 1, right = N, target = A[idx];
	
		while(left < right) {
			if(left == idx) left++;
			else if(right == idx) right--;
			else {
				if(A[left] + A[right] < target) left ++;
				else if(A[left] + A[right] == target) return true;
				else right --;
			}
		}
		
		return false;
	}
	
}
