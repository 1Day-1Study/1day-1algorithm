import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mana_Allow_6236 {

	static int N, M;
	static int max;
	static int[] spend;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		max = 0;
		spend = new int[N];
		
		for(int i=0; i<N; i++) {
			spend[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, spend[i]);
		}
		
		int left = max;
		int right = 1000000000;
		int ans = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2 ;
			
			if(withdraw(mid)) {
				ans = mid;
				right = mid -1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean withdraw(int mid) {
		int count = 1;
		int sum = 0;
		
		for(int i =0; i < N; i++) {
			if(sum + spend[i] > mid) {
				count ++;
				sum = spend[i];
			}else {
				sum += spend[i];
			}
			
			sum -= spend[i];
		}
		return count <= M;
	}
}
