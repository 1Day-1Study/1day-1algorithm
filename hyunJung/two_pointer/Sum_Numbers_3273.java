import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sum_Numbers_3273 {
	
	static int n, x;
	static int[] nums;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums, 1, n+1);
		
		x = Integer.parseInt(br.readLine());
		
		br.close();
	}
	
	static void two_pointer() {
		int left = 1, right = n, ans = 0;
		
		while(left < right) {
			if(nums[left] + nums[right] == x) ans++;
			
			if(nums[left] + nums[right] >= x) right--;
			else left++;
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		two_pointer();
	}
	
}
