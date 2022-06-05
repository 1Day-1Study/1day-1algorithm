import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Partial_Sum_1806 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int start = 0, end = 0;
		int span = Integer.MAX_VALUE;
		int sum = 0;
		
		while(start <= end && end <= N) {
			if(sum < S) {
				sum += arr[end++];
			} else if(sum >= S) {
				span = Math.min(span, end-start);
				sum -= arr[start++];
			}  
		}
		
		System.out.println(span==Integer.MAX_VALUE ? 0 : span);
	}
	
}
