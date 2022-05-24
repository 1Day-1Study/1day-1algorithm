import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Finding_Num_1920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++)  {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());

			if(binary_search(arr, target, 0, arr.length-1)) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean binary_search(int[] arr, int target, int left, int right) {
		
		while(left <= right) {
			int mid = (left+right)/2;

			if(arr[mid] == target) {
				return true;
			}
			
			if(arr[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return false;
	}
}
